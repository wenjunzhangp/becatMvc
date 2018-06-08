package com.baozi.vo;

import com.baozi.enums.NoticeEnum;
import com.baozi.util.IDEncryptor;
import com.baozi.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class NoticeViewVo {
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

    public String getId() {
        return IDEncryptor.getInstance().encryptWithoutException(id);
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
        return NoticeEnum.genNoticeCategory(category).getName();
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
        return StringUtil.removeHtml(content.length()<60?content.trim(): StringUtil.shortStrEnd(content.trim(),60));
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}