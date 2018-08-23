package com.baozi.config;


import com.alibaba.fastjson.JSONObject;
import com.baozi.util.HttpclientUtil;
import com.baozi.util.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

public class WeiXinManager {

	public static final String GET_ACCESS_TOKEN_URL = WeiXinConfig.get("get_access_token_url");
	public static final String APP_SECRET = WeiXinConfig.get("app_Secret");
	public static final String APP_ID = WeiXinConfig.get("app_ID");
	public static final String GRANT_TYPE = "client_credential";

	private static String token;

	public static String httpToken() {
		try {
			// 获取当前客户端对象
			Map<String, String> param = new HashMap<>(256);
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
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				LogUtils.logInfo("*****************************获取微信token*****************************");
				//定期一小时获取一次token
				token = httpToken();
			}
		};
		ScheduledExecutorService service = newScheduledThreadPool(2);
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleWithFixedDelay(runnable, 60, 60, TimeUnit.SECONDS);
	}
}
