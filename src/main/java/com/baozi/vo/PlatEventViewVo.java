package com.baozi.vo;

import com.baozi.util.IDEncryptor;
import com.baozi.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlatEventViewVo {
    private Integer id;

    private String title;

    private Date edate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private Integer status;

    private Integer display;

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

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getContent() {
        return content.length()<30?content: StringUtil.shortStrEnd(content,35);
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}