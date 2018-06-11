package com.baozi.po;

import java.util.Date;

public class Blog {
    private Integer id;

    private String title;

    private String author;

    private Integer fabulous;

    private Integer looknum;

    private Integer category;

    private Integer sharenum;

    private String abstractremark;

    private Boolean stick;

    private Integer display;

    private Integer status;

    private Date createtime;

    private Date lastmodifytime;

    private String source;

    private Integer type;

    private String content;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getFabulous() {
        return fabulous;
    }

    public void setFabulous(Integer fabulous) {
        this.fabulous = fabulous;
    }

    public Integer getLooknum() {
        return looknum;
    }

    public void setLooknum(Integer looknum) {
        this.looknum = looknum;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSharenum() {
        return sharenum;
    }

    public void setSharenum(Integer sharenum) {
        this.sharenum = sharenum;
    }

    public String getAbstractremark() {
        return abstractremark;
    }

    public void setAbstractremark(String abstractremark) {
        this.abstractremark = abstractremark == null ? null : abstractremark.trim();
    }

    public Boolean getStick() {
        return stick;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}