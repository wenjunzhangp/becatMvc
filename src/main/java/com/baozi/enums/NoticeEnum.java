package com.baozi.enums;

/**
 * Copyright:   becat
 * 平台公告枚举类定义
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-07 13:43
 */
public enum NoticeEnum {

    /**
     * 通告
     */
    NOTICE_NORMAL("通告",0),
    /**
     * 活动
     */
    NOTICE_ACTIVITY("活动",1),
    /**
     * 放假
     */
    NOTICE_HOLIDAY("放假",2),
    /**
     * 交易
     */
    NOTICE_TRADE("交易",3)
    ;
    //用于获取说明，
    private String name;
    //获取数值
    private Integer index;
    private NoticeEnum(String name, Integer index) {
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

    public static NoticeEnum genNoticeCategory(int key){
        for (NoticeEnum shareInfoType : NoticeEnum.values()) {
            if(key == shareInfoType.getIndex()){
                return shareInfoType;
            }
        }
        return NOTICE_NORMAL;
    }
}
