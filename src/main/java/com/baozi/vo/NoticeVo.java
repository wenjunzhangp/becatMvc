package com.baozi.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class NoticeVo {
    private Integer id;

    private String title;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private Integer category;

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date publictime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastmodifytime;

    private Integer display;

    private String img;

    private String content;

    public static enum NoticeCategoryEnum{
        type_unknow(0,"未知"),
        type_notice(1,"公告"),
        TYPE_activity(2,"活动");

        private NoticeCategoryEnum(int typeNum, String typeName){
            this.setTypeNum(typeNum);
            this.setTypeName(typeName);
        }

        private int typeNum;

        private String typeName;

        public int getTypeNum() {
            return typeNum;
        }

        public void setTypeNum(int typeNum) {
            this.typeNum = typeNum;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public static NoticeCategoryEnum genNoticeCategory(int key){
            for (NoticeCategoryEnum shareInfoType : NoticeCategoryEnum.values()) {
                if(key == shareInfoType.getTypeNum()){
                    return shareInfoType;
                }
            }
            return type_unknow;
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCategory() {
        return NoticeCategoryEnum.genNoticeCategory(category).getTypeName();
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPublictime() {
        return publictime;
    }

    public void setPublictime(Date publictime) {
        this.publictime = publictime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}