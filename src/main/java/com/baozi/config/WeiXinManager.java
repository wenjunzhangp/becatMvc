package com.baozi.config;


import com.alibaba.fastjson.JSONObject;
import com.baozi.util.HttpclientUtil;
import com.baozi.util.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class WeiXinManager {

	public static final String GET_ACCESS_TOKEN_URL = WeiXinConfig.get("get_access_token_url");
	public static final String APP_SECRET = WeiXinConfig.get("app_Secret");
	public static final String APP_ID = WeiXinConfig.get("app_ID");
	public static final String GRANT_TYPE = "client_credential";

	private static String token;

	public static String httpToken() {
		try {
			// 获取当前客户端对象
			Map<String, String> param = new HashMap<String, String>();
			param.put("grant_type",WeiXinManager.GRANT_TYPE);
			param.put("appid",WeiXinManager.APP_ID);
			param.put("secret",WeiXinManager.APP_SECRET);
			String responStr = HttpclientUtil.doGet(WeiXinManager.GET_ACCESS_TOKEN_URL,param);
			JSONObject jsonObject = JSONObject.parseObject(responStr);
			token = jsonObject.getString("access_token");
		} catch (Exception e) {
			LogUtils.logError("获取token失败",e);
		}
		return token;
	}

	public static String getToken() {
		return token;
	}

	static {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				//定期一小时获取一次token
				token = httpToken();
			}
		}, 0, 3600000);
	}
}
