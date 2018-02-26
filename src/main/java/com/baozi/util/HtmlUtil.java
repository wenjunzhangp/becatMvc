package com.baozi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.Set;

public class HtmlUtil {

	private static Set<String> newLineTag = new HashSet<String>();
	private static Set<String> unVisibleTag = new HashSet<String>();
	private static Set<String> htmlLineTag = new HashSet<String>();
	private static Logger logger = LoggerFactory.getLogger("HtmlUtil");
	static {
		newLineTag.add("TR");
		newLineTag.add("P");
		newLineTag.add("DIV");
		newLineTag.add("BR");
		
		htmlLineTag.addAll(newLineTag);
		htmlLineTag.add("LI");
		
		unVisibleTag.add("STYLE");
	}
	
	public static boolean isNewLineTag(String tagName) {
		return newLineTag.contains(tagName);
	}
	
}
