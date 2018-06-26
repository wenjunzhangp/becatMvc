package com.baozi.enums;

/**
 * Copyright:   becat
 * 技术博客分类（java c# python php linux technology）枚举类定义
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-07 13:43
 */
public enum BlogCategoryEnum {

    /**
     * 未知来源
     */
    BLOG_CATEGORY_NORMAL("未知来源",0),
    /**
     * java
     */
    BLOG_CATEGORY_JAVA("Java",1),
    /**
     * 技术
     */
    BLOG_CATEGORY_TECHNOLOGY("技术",2),
    /**
     * linux
     */
    BLOG_CATEGORY_LINUX("Linux",3),
    /**
     * c#
     */
    BLOG_CATEGORY_NET("c#",4),
    /**
     * python
     */
    BLOG_CATEGORY_PYTHON("Python",5),
    /**
     * php
     */
    BLOG_CATEGORY_PHP("Php",6);
    //用于获取说明，
    private String name;
    //获取数值
    private Integer index;
    private BlogCategoryEnum(String name, Integer index) {
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    public static BlogCategoryEnum genNoticeCategory(int key){
        for (BlogCategoryEnum shareInfoType : BlogCategoryEnum.values()) {
            if(key == shareInfoType.getIndex()){
                return shareInfoType;
            }
        }
        return BLOG_CATEGORY_NORMAL;
    }
}
