package com.baozi.util;

import com.baozi.statics.Constant;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class IpUtil {
	private static IpUtil instance = new IpUtil();
	private IpUtil(){}
	
	public static IpUtil getInstance(){
		return instance;
	}
	
	private final static String ERROR_IP = "127.0.0.1";
	
	public String getRealIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}


		if (ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if(ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if(Constant.INTEGER_NUM.equals(ip)) {
				{
					ip = ERROR_IP;
				}
			}
		}
		
		if ( Constant.UNKNOWN.equalsIgnoreCase(ip)) {
			ip = ERROR_IP;
			return ip;
		}
		
		int pos = ip.indexOf(',');
		if (pos >= 0) {
			ip = ip.substring(0, pos);
		}
		
		return ip;
	}
	
	public static void main(String[] args){
		List<Integer> ims = new ArrayList<Integer>();
		ims.add(100);ims.add(100);ims.add(100);ims.add(100);ims.add(100);ims.add(100);
		ims.add(200);ims.add(200);ims.add(200);
		ims.add(500);ims.add(500);
		ims.add(1000);
		
		int i1 = 0;
		int i2 = 0;
		int i5 = 0;
		int i10 = 0;
		for(int i = 0; i < 1000; i++) {
			int r = (int)(Math.random() * ims.size());
			int rr = ims.get(r);
			if (rr == 100) {
				i1++;
			} else if (rr == 200) {
				i2++;
			} else if (rr == 500) {
				i5++;
			} else {
				i10++;
			}
		}
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i5);
		System.out.println(i10);
	}
}
