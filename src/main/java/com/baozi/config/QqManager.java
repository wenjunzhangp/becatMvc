package com.baozi.config;

import com.baozi.util.LogUtils;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.qzone.Topic;
import com.qq.connect.javabeans.GeneralResultBean;
import com.qq.connect.oauth.Oauth;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class QqManager {
	public static final String REDIRECT_URL = QqConfig.get("redirect_URI");
	public static final String APP_KEY = QqConfig.get("app_KEY");
	public static final String APP_ID = QqConfig.get("app_ID");

	/**
	  * 获取用户token信息
	  * response_type 	必须 	授权类型，此值固定为“code”。
	  * client_id 		必须 	申请QQ登录成功后，分配给应用的appid。
	  * redirect_uri 	必须 	成功授权后的回调地址，必须是注册appid时填写的主域名下的地址，建议设置为网站首页或网站的用户中心。注意需要将url进行URLEncode。
	  * state 			必须 	client端的状态值。用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。请务必严格按照流程检查用户与state参数状态的绑定。
	  * scope 			可选 	请求用户授权时向用户显示的可进行授权的列表。
	  * 						可填写的值是API文档中列出的接口，以及一些动作型的授权（目前仅有：do_like），如果要填写多个接口名称，请用逗号隔开。
	  * 						例如：scope=get_user_info,list_album,upload_pic,do_like
	  * 						不传则默认请求对接口get_user_info进行授权。
	  * 						建议控制授权项的数量，只传入必要的接口名称，因为授权项越多，用户越可能拒绝进行任何授权。
	  * display 		可选 	仅PC网站接入时使用。
	  * 
	  * 						用于展示的样式。不传则默认展示为PC下的样式。
	  * 
	  * 						如果传入“mobile”，则展示为mobile端下的样式。
	  * g_ut 			可选 	仅WAP网站接入时使用。
	  * 
	  * 						QQ登录页面版本（1：wml版本； 2：xhtml版本），默认值为1。
	  * 
	  * 
	  * 返回说明：
		如果成功返回，即可在返回包中获取到Access Token。 如：
		
		access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14
		
		参数说明 	描述
		access_token 	授权令牌，Access_Token。
		expires_in 	该access token的有效期，单位为秒。
		refresh_token 	在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。
	 */
	public static String getAuth2URL(String state, String redirectUrl, String code){
		String url = "https://graph.qq.com/oauth2.0/token";
		url += "?grant_type=authorization_code";
		url += "&client_id="+ QqManager.APP_ID;
		url += "&client_secret="+ QqManager.APP_KEY;
		url += "&code="+code;
		url += "&redirect_uri="+redirectUrl;
		return url;
	}
	
	
	/**
	 * 
	 * Step3：（可选）权限自动续期，获取Access Token
    *
	*	Access_Token的有效期默认是3个月，过期后需要用户重新授权才能获得新的Access_Token。本步骤可以实现授权自动续期，避免要求用户再次授权的操作，提升用户体验。
	*
	*	请求地址：
	*	
	*	PC网站：https://graph.qq.com/oauth2.0/token
	*
	*	WAP网站：https://graph.z.qq.com/moc2/token
	*
	*	请求方法：
	*
	*	GET
	*
	*	请求参数：
	*
	*	请求参数请包含如下内容：
	*	参数 	是否必须 	含义
	*	grant_type 	必须 	授权类型，在本步骤中，此值为“refresh_token”。
	*	client_id 	必须 	申请QQ登录成功后，分配给网站的appid。
	*	client_secret 	必须 	申请QQ登录成功后，分配给网站的appkey。
	*	refresh_token 	必须 	在Step2中，返回的refres_token。
	*	返回说明：
		如果成功返回，即可在返回包中获取到Access Token。 如：
		
		access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14。
		
		 
		参数说明 	描述
		access_token 	授权令牌，Access_Token。
		expires_in 	该access token的有效期，单位为秒。
		refresh_token 	在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。
	 */

	/**
	 * 发表说说
	 * return  false || true 
	 */
	public static Boolean pushShuoShuo(String accessToken, String openID , String content){
		Boolean result = true;
		Topic topic = new Topic(accessToken, openID);
		try {
	        GeneralResultBean grb = topic.addTopic("test f1111111111111");
	        if (grb.getRet() == 0) {
				LogUtils.logError("您的说说已发表成功，请登录Qzone查看");
	        } else {
				LogUtils.logError("很遗憾的通知您，发表说说失败！原因： " + grb.getMsg());
	      	  return false;
	        }
	    } catch (QQConnectException e) {
	    	//please invoke the setOpenID and setToken first!
			LogUtils.logError("抛异常了？" + e.getMessage());
	        return false;
	    }
		return result ;
	}
	/**
	 * 弹框登录QQ授权
	 * @param request
	 * @param response
	 * @param redirect
	 */
	@RequestMapping("qq")
	public static void qq(HttpServletRequest request, HttpServletResponse response, String redirect){
		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (IOException e) {
			LogUtils.logError("调用腾讯登录接口失败,errorMessage:" + e.getMessage());
			e.printStackTrace();
		} catch (QQConnectException e) {
			LogUtils.logError("调用腾讯登录接口失败,errorMessage:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
