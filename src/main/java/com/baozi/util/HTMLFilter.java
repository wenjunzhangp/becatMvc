package com.baozi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML标签过滤实用类，防止针对评论的XSS跨站脚本攻击
 * 
 * @created 2013-4-8
 *
 */
public class HTMLFilter {

	public static String removeHTMLTags(String str, String tags) {
		if (str == null)
			return null;
		if (tags == null)
			return str;
		String regx = "(</?)(" + tags + ")([^>]*>)";
		Matcher matcher;
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE
				+ Pattern.MULTILINE);// 不区分大小写
		// 此处需要循环匹配，防止恶意构造的字符串
		while ((matcher = pattern.matcher(str)).find()) {
			str = matcher.replaceAll("");
		}
		return str;
	}
	
	public static String removeEvents(String content) {
		String regx = "(<[^<]*)(on\\w*\\x20*=|javascript:)";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE
				+ Pattern.MULTILINE);// 不区分大小写
		Matcher matcher;
		String ts = content;
		// 此处需要循环匹配，防止恶意构造的字符串如 onclick=onclick=XXX
		while ((matcher = pattern.matcher(ts)).find()) {
			ts = matcher.replaceAll("$1");
		}
		return ts;
	}
	
	public static String Html2Text(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
            String textStr ="";
      java.util.regex.Pattern p_script;
      java.util.regex.Matcher m_script;
      java.util.regex.Pattern p_style;
      java.util.regex.Matcher m_style;
      java.util.regex.Pattern p_html;
      java.util.regex.Matcher m_html;
  
      try {
       String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
       String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
          String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
     
          p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
          m_script = p_script.matcher(htmlStr);
          htmlStr = m_script.replaceAll(""); //过滤script标签

          p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
          m_style = p_style.matcher(htmlStr);
          htmlStr = m_style.replaceAll(""); //过滤style标签
     
          p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
          m_html = p_html.matcher(htmlStr);
          htmlStr = m_html.replaceAll(""); //过滤html标签
     
       textStr = htmlStr;
     
      }catch(Exception e) {
               System.err.println("Html2Text: " + e.getMessage());
      }
  
      return textStr;//返回文本字符串
       }   
	
	public static String makeSafe(String content) {
		//content = content.replaceAll("<[^>]+>","");
		content = Html2Text(content);
		//return removeEvents(removeHTMLTags(content,"html|body|head|title|style|video|canvas|iframe|frameset|frame|object|embed|xml|input|button|textarea|select|pre|option|plaintext|form|img|script|alert"));
		return content;
	}
	
	public static String makeSafe(String content, String tags) {
		if (tags == null)
			return makeSafe(content);
		return removeEvents(removeHTMLTags(content, tags));
	}
	
	/**
	 * @param args
	 * @author yuxuan.zhai
	 * @created 2013-4-8
	 */
	public static void main(String[] args) {
		System.out.println(makeSafe("<img src=\"111\"/>dfdf<a href=\"111\" onclick=onclick=alert(1) href=\"javascript:alert(1)\">22233</a><plaintext><script type=\"javascript\">alert(123)</script><p onclick= '111'>111</p>"));
		System.out.println(Html2Text("<img src=\"111\"/>dfdf<a href=\"111\" onclick=onclick=alert(1) href=\"javascript:alert(1)\">22233</a><plaintext><script type=\"javascript\">alert(123)</script><p onclick= '111'>111</p>"));
	}

}
