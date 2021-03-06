package com.baozi.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.baozi.config.Iconfig;
import com.baozi.config.WeiXinConfig;
import com.baozi.statics.Constant;
import com.baozi.vo.weixin.Article;
import com.baozi.vo.weixin.NewsMessage;
import com.baozi.vo.weixin.TextMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 * 实现微信智能回复的工具类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 10:50
 */
public class WeiXinMessageFactory {

    /**
     * 处理微信交互文本消息
     * @param fromUserName 用户昵称
     * @param toUserName 公众号昵称
     * @param msgType 消息类型 text
     * @param content 用户发送的内容
     * @return
     */
    public static String handleWeiXinTextMessage( String fromUserName,String toUserName,String msgType,String content ){
        if (content.endsWith(Constant.WECHAT_LUMAO)) {
            return handleWeiXinNewsImageMessage(fromUserName,toUserName);
        } else if (content.endsWith(Constant.WECHAT_SINGSONG)) {
            return encapsulation(fromUserName,toUserName);
        } else {
            StringBuffer sb = new StringBuffer();
            //这里根据关键字执行相应的逻辑，只有你想不到的，没有做不到的
            if(Constant.WECHAT_HELLO.equals(content)){
                sb.append("你好\n\n");
                sb.append("该公众号已实现以下功能：\n");
                sb.append("1.回复“天气”将有该功能的介绍与使用\n");
                sb.append("2.图灵机器人实现智能聊天\n");
                sb.append("3.回复“撸猫”，我们都会有猫的\n");
                sb.append("4.回复“唱歌”听歌曲\n");
                sb.append("5.更多功能尽在开发中...\n");
                sb.append("官网链接是“https://www.doudoucat.com”");
            } else if(Constant.WECHAT_WEATHER.equals(content)){
                sb.append("目前支持查看昨天、今天和未来4 天的天气预报\n");
                sb.append("回复“您要查询的省份”后面跟上天气即可\n");
                sb.append("例如查看北京天气：“北京天气”");
            } else if (content.endsWith(Constant.WECHAT_WEATHER)) {
                Map<String, String> param = new HashMap<>(256);
                String city = content.substring(0,Constant.WECHAT_WEATHER.length());
                param.put("city",city);
                String responStr = HttpclientUtil.doGet(Iconfig.get("weather_api_url"),param);
                JSONObject jsonObject = JSONObject.parseObject(responStr);
                if (String.valueOf(Constant.HTTP_OK).equals(jsonObject.getString("status"))) {
                    JSONObject data = jsonObject.getJSONObject("data");
                    sb.append("今日温度"+data.get("wendu")+"℃，湿度"+data.get("shidu")+"，空气等级“"+data.get("quality")+"“，PM2.5："+data.get("pm25")+"\n");
                    sb.append("小编温馨提示:\n"+data.get("ganmao"));
                    sb.append("\n__________________________\n");
                    sb.append("\n未来四天天气走势：\n");
                    JSONArray jsonArray = JSONArray.parseArray(data.getString("forecast"));
                    for (int i=0;i<jsonArray.size();i++) {
                        JSONObject json = jsonArray.getJSONObject(i);
                        sb.append(json.get("date")+"\t\t"+json.get("type")+"\t\t"+json.get("low")+"~"+json.get("high")+"\t\t风向:"+json.get("fx"));
                        sb.append("\n小编温馨提示:\n"+json.get("notice")+"\n");
                        if (jsonArray.size()-1!=i) {
                            sb.append("\n__________________________\n\n");
                        }
                    }
                } else {
                    sb.append("天气信息被外星人劫走了呢，请稍后再试~");
                }
            } else {
                sb.append(getTulingResult(content));
            }
            TextMessage text = new TextMessage();
            text.setContent(sb.toString());
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(System.currentTimeMillis() + "");
            text.setMsgType(msgType);
            return MessageUtil.textMessageToXml(text);
        }
    }

    /**
     * 处理微信交互语音消息
     * @param requestMap
     * @return
     */
    public static String handleWeiXinVoiceMessage( Map<String, String> requestMap,String fromUserName,String toUserName ){
        String respMessage = "";
        String recvMessage = requestMap.get("Recognition");
        LogUtils.logInfo("解析的语音结果是【"+recvMessage+"】");
        if(StringUtil.isNotEmpty(recvMessage)){
            //进行语音解析
            respMessage = getTulingResult(recvMessage);
        } else if (recvMessage.indexOf(Constant.WECHAT_SINGSONG)!=-1) {
            respMessage = encapsulation(fromUserName,toUserName);
        } else{
            respMessage = "您说的太模糊了，小豆没听清!";
        }
        return respMessage;
    }

    /**
     * 拼装返回语音消息 唱一首歌
     * @return
     */
    private static String encapsulation(String fromUserName,String toUserName) {
        String respMessage = "";
        NewsMessage newsMessage = new NewsMessage();
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setTitle("没有车没有房--孙辉");
        article.setDescription("你的存折有几张~");
        article.setPicUrl("http://source.doudoucat.com/muisc.png");
        article.setUrl("https://music.163.com/song?id=865048215&userid=292060520");
        articles.add(article);
        newsMessage.setArticleCount(1);
        newsMessage.setArticles(articles);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(System.currentTimeMillis() + "");
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        respMessage = MessageUtil.newsMessageToXml(newsMessage);
        return respMessage;
    }

    /**
     * 处理微信交互各种事件 订阅 取消订阅 自定义菜单点击事件
     * @param fromUserName 用户昵称
     * @param toUserName 公众号昵称
     * @param requestMap 微信请求的map
     * @return
     */
    public static String handleWeiXinEventPush( String fromUserName,String toUserName,Map<String, String> requestMap ){
        String respMessage = "";
        // 事件类型
        String eventType = requestMap.get("Event");
        // 订阅
        if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
            TextMessage text = new TextMessage();
            StringBuffer sb = new StringBuffer();
            sb.append("欢迎关注，BeCat撸猫订阅号\n\n");
            sb.append("该公众号已实现以下功能：\n");
            sb.append("1.回复“天气”将有该功能的介绍与使用\n");
            sb.append("2.图灵机器人实现智能聊天\n");
            sb.append("3.回复“撸猫”，我们都会有猫的~\n");
            sb.append("4.回复“唱歌”听歌曲\n");
            sb.append("5.更多功能尽在开发中...\n");
            sb.append("如您在使用该订阅号有任何宝贵意见，欢迎反馈！\n\n");
            sb.append("反馈邮箱：zhangwenjunp@126.com\n\n");
            sb.append("官网链接是“https://www.doudoucat.com”");
            text.setContent(sb.toString());
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(System.currentTimeMillis() + "");
            text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            respMessage = MessageUtil.textMessageToXml(text);
        } else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
            // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
            LogUtils.logInfo("用户:" + fromUserName + ",取消订阅");
        } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
            // 事件KEY值，与创建自定义菜单时指定的KEY值对应
            String eventKey = requestMap.get("EventKey");
            if (Constant.WECHAT_CLICK_EVENT_ABOUT.equals(eventKey)) {
                TextMessage text = new TextMessage();
                text.setContent("18811359094");
                text.setToUserName(fromUserName);
                text.setFromUserName(toUserName);
                text.setCreateTime(System.currentTimeMillis() + "");
                text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                respMessage = MessageUtil.textMessageToXml(text);
            }
        }
        return respMessage;
    }

    public static void main(String[] args) {
        System.out.println(handleWeiXinNewsImageMessage("张飒","微信订阅号"));
    }

    /**
     * 处理微信交互图像文本消息
     * @param fromUserName 用户昵称
     * @param toUserName 公众号昵称
     * @return
     */
    public static String handleWeiXinNewsImageMessage(String fromUserName,String toUserName) {
        String respMessage = "";
        NewsMessage newsMessage = new NewsMessage();
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setTitle("豆豆的蓝胖子全网最低价");
        article.setDescription("想撸猫就来这里，这辈子不能没有猫!");
        article.setPicUrl("http://source.doudoucat.com/timg.png");
        article.setUrl("https://www.doudoucat.com/pet.shtml");
        articles.add(article);
        newsMessage.setArticleCount(1);
        newsMessage.setArticles(articles);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(System.currentTimeMillis() + "");
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        respMessage = MessageUtil.newsMessageToXml(newsMessage);
        return respMessage;
    }

    /**
     * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
     * @param content
     * @return
     */
    private static String getTulingResult(String content){
        //图灵机器人数据库接口
        StringBuffer sb = new StringBuffer();
        String result = "";
        try {
            String info = URLEncoder.encode(content, "utf-8");
            String getURL = WeiXinConfig.get("tuling_robot_url")+"?key=" + WeiXinConfig.get("tuling_robot_appkey") + "&info=" + info;
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl
                    .openConnection();
            connection.connect();

            // 取得输入流，并使用Reader读取
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "utf-8"));

            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            JSONObject json = JSONObject.parseObject(sb.toString());
            result = json.getString("text");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

}
