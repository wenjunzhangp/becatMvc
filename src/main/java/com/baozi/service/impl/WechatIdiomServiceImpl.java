package com.baozi.service.impl;

import com.alibaba.fastjson.JSON;
import com.baozi.mappers.WechatIdiomMapper;
import com.baozi.po.WechatIdiom;
import com.baozi.service.WechatIdiomService;
import com.baozi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:   互融云
 *
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-09-30 10:57
 */
@Service
public class WechatIdiomServiceImpl implements WechatIdiomService {

    @Autowired
    private WechatIdiomMapper wechatIdiomMapper;

    @Override
    public List<WechatIdiom> findWechatIdiomServiceALL() {
        return wechatIdiomMapper.findWechatIdiomServiceALL();
    }

    @Override
    public void updateAnswer(List<WechatIdiom> wechatIdiom) {
        if ( null == wechatIdiom || wechatIdiom.size()<0 ) {
            return;
        }
        for (int i=0;i<wechatIdiom.size();i++) {
            WechatIdiom data = wechatIdiom.get(i);
            List<Map<String,Object>> dataList = new ArrayList<>();
            //给定一个字符串，把每个字符截取粗来
            String answer = data.getName();
            answer = answer.substring(answer.indexOf("：")+1,answer.length());
            String[] str = new String[answer.length()];
            for (int j = 0;j<answer.length();j++) {
                str[j] = String.valueOf(answer.charAt(j));
            }
            for (int m = 0;m<20;m++) {
                Map<String,Object> map = new HashMap<>(16);
                map.put("num",m+1);
                map.put("zi",StringUtil.getRandomChar());
                map.put("isChecked","false");
                dataList.add(map);
            }
            Map<String,Object> one = new HashMap<>(16);
            one.put("num",21);
            one.put("zi",str[0]);
            one.put("isChecked","false");
            dataList.add(one);
            Map<String,Object> two = new HashMap<>(16);
            two.put("num",22);
            two.put("zi",str[1]);
            two.put("isChecked","false");
            dataList.add(two);
            Map<String,Object> three = new HashMap<>(16);
            three.put("num",23);
            three.put("zi",str[2]);
            three.put("isChecked","false");
            dataList.add(three);
            Map<String,Object> four = new HashMap<>(16);
            four.put("num",24);
            four.put("zi",str[3]);
            four.put("isChecked","false");
            dataList.add(four);
            Collections.shuffle(dataList);
            data.setAnswer(JSON.toJSONString(dataList));
            wechatIdiomMapper.updateByPrimaryKey(data);
        }
    }

    public static void main(String[] args) {
        //成语猜猜猜答案格式
        String string = "[{'num':'1','zi':'为','isChecked':false},{'num':'2','zi':'是','isChecked':false},{'num':'3','zi':'话','isChecked':false},{'num':'4','zi':'多','isChecked':false},{'num':'5','zi':'口','isChecked':false},{'num':'6','zi':'醉','isChecked':false},{'num':'7','zi':'最','isChecked':false},{'num':'8','zi':'嘴','isChecked':false},{'num':'9','zi':'时','isChecked':false},{'num':'10','zi':'石','isChecked':false},{'num':'11','zi':'事','isChecked':false},{'num':'12','zi':'情','isChecked':false},{'num':'13','zi':'对','isChecked':false},{'num':'14','zi':'错','isChecked':false},{'num':'15','zi':'无','isChecked':false},{'num':'16','zi':'心','isChecked':false},{'num':'17','zi':'脏','isChecked':false},{'num':'18','zi':'非','isChecked':false},{'num':'19','zi':'费','isChecked':false},{'num':'20','zi':'也','isChecked':false},{'num':'21','zi':'好','isChecked':false},{'num':'22','zi':'差','isChecked':false},{'num':'23','zi':'叉','isChecked':false},{'num':'24','zi':'勾','isChecked':false}]";
    }
}
