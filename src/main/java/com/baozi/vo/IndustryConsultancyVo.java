package com.baozi.vo;

import com.baozi.util.IConfig;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author wenjun.zhang
 * @create 2018-03-29 9:33
 * @description 文章表分页bean
 **/
public class IndustryConsultancyVo {

    private Integer id;

    private String title;

    private Boolean display;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date publictime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastmodifytime;

    private Integer status;

    private String major;

    private String remark;

    private Integer category;

    private String source;

    private Integer sharenumber;

    private Integer looknumber;

    private String sourceimg;

    private String description;

    private String carouselposition;

    private Boolean hot;

    private String content;

    private String name;

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

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getSharenumber() {
        return sharenumber;
    }

    public void setSharenumber(Integer sharenumber) {
        this.sharenumber = sharenumber;
    }

    public Integer getLooknumber() {
        return looknumber;
    }

    public void setLooknumber(Integer looknumber) {
        this.looknumber = looknumber;
    }

    public String getSourceimg() {
        return IConfig.get("becat.imgserver.prefix")+sourceimg;
    }

    public void setSourceimg(String sourceimg) {
        this.sourceimg = sourceimg == null ? null : sourceimg.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCarouselposition() {
        return carouselposition;
    }

    public void setCarouselposition(String carouselposition) {
        this.carouselposition = carouselposition == null ? null : carouselposition.trim();
    }

    public int getHot() {
        return hot?1:0;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
