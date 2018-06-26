package com.baozi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML标签过滤实用类，防止针对评论的XSS跨站脚本攻击
 * 
 * @created 2013-4-8
 *
 */
public class HtmlFilter {

	public static String removeHTMLTags(String str, String tags) {
		if (str == null) {
			{
				return null;
			}
		}
		if (tags == null) {
			{
				return str;
			}
		}
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
	
	public static String html2Text(String inputString) {
	//含html标签的字符串
	String htmlStr = inputString;
	String textStr ="";
      java.util.regex.Pattern pScript;
      java.util.regex.Matcher mScript;
      java.util.regex.Pattern pStyle;
      java.util.regex.Matcher mStyle;
      java.util.regex.Pattern pHtml;
      java.util.regex.Matcher mHtml;
  
      try {
		  //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
		  String regExScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
		  //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
		  String regExStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
		  //定义HTML标签的正则表达式
          String regExHtml = "<[^>]+>";
     
          pScript = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
          mScript = pScript.matcher(htmlStr);
		  //过滤script标签
          htmlStr = mScript.replaceAll("");

          pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
          mStyle = pStyle.matcher(htmlStr);
		  //过滤style标签
          htmlStr = mStyle.replaceAll("");
     
          pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
          mHtml = pHtml.matcher(htmlStr);
		  //过滤html标签
          htmlStr = mHtml.replaceAll("");
     
       textStr = htmlStr;
     
      }catch(Exception e) {
               System.err.println("Html2Text: " + e.getMessage());
      }
		//返回文本字符串
      return textStr;
       }   
	
	public static String makeSafe(String content) {
		content = html2Text(content);
		return content;
	}
	
	public static String makeSafe(String content, String tags) {
		if (tags == null) {
			{
				return makeSafe(content);
			}
		}
		return removeEvents(removeHTMLTags(content, tags));
	}
	
	/**
	 * @param args
	 * @author yuxuan.zhai
	 * @created 2013-4-8
	 */
	public static void main(String[] args) {
		System.out.println(makeSafe("<img src=\"111\"/>dfdf<a href=\"111\" onclick=onclick=alert(1) href=\"javascript:alert(1)\">22233</a><plaintext><script type=\"javascript\">alert(123)</script><p onclick= '111'>111</p>"));
		System.out.println(html2Text("<img src=\"111\"/>dfdf<a href=\"111\" onclick=onclick=alert(1) href=\"javascript:alert(1)\">22233</a><plaintext><script type=\"javascript\">alert(123)</script><p onclick= '111'>111</p>"));
	}

}
