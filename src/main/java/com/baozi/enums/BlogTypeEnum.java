package com.baozi.enums;

/**
 * Copyright:   becat
 * 技术博客类型（原创 转载）枚举类定义
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-07 13:43
 */
public enum BlogTypeEnum {

    BLOG_TYPE_NORMAL("未知来源",0),
    BLOG_TYPE_YUANCHAUNG("原创",1),
    BLOG_TYPE_ZHUANZAI("转载",2);
    private String name;  //用于获取说明，
    private Integer index;  //获取数值
    private BlogTypeEnum(String name, Integer index) {
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

    public static BlogTypeEnum genNoticeCategory(int key){
        for (BlogTypeEnum shareInfoType : BlogTypeEnum.values()) {
            if(key == shareInfoType.getIndex()){
                return shareInfoType;
            }
        }
        return BLOG_TYPE_NORMAL;
    }
}
