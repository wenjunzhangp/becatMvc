package com.baozi.po;

import com.baozi.statics.Constant;
import com.baozi.util.DateUtil;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * 
 * 模拟多说评论实体
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年5月2日 19:48 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0,2017年5月2日 19:48 <br/>
 * 
 */
public class SOMessage implements Serializable{
	private static final long serialVersionUID = 1434473283877857750L;
	/**评论id**/
	private Long id;
	/**创建时间**/
    private Date createdTime;
    private String createdTimeStr;
    private String createdYMDHMSStr;//年月日，时分秒全时间
    private String createdTimeZooe;//年月日，时分秒全时间，带时区，如：2017-04-26T14:22:27+08:00
    /**父类id**/
    private Long parentId = Constant.ZERO;
    /**顶的次数**/
    private Integer likes = 0;
    /**浏览器信息**/
    private String agent;
    /**ip**/
    private String ip;
    /**ip地址**/
    private String iplocation;
    /**评价人id**/
    private Long authorId;
    /**key**/
    private String pkey;
    /**评价来源**/
    private String referer;
    /**评价内容**/
    private String message;
    /**子父类关系id*/
    private String pids;
    /**层级ID*/
    private Integer level;
    
    public SOMessage(JsonObject jsonObj, Integer level, String pids, Long parentId, Long authorId) {
    	
    	if(null != jsonObj.get("message") && !jsonObj.get("message").isJsonNull()){
    		this.message = jsonObj.get("message").getAsString();
    	}
    	this.authorId = authorId;
		if(null != jsonObj.get("agent") && !jsonObj.get("agent").isJsonNull()){
			this.agent = jsonObj.get("agent").getAsString();
		}
		if(null != jsonObj.get("likes") && !jsonObj.get("likes").isJsonNull()){
			this.likes = jsonObj.get("likes").getAsInt();
		}
		if(null != jsonObj.get("ip") && !jsonObj.get("ip").isJsonNull()){
			this.ip = jsonObj.get("ip").getAsString();
		}
		if(null != jsonObj.get("iplocation") && !jsonObj.get("iplocation").isJsonNull()){
			this.iplocation = jsonObj.get("iplocation").getAsString();
		}
		if(null != jsonObj.get("created_at") && !jsonObj.get("created_at").isJsonNull()){
			String createdTime = jsonObj.get("created_at").getAsString();
			try {
				//时间转换
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"); 
				Date date = df.parse(createdTime);
				this.createdTime = date; 
			} catch (Exception e) {
				this.createdTime = new Date(); 
			}
		}
		this.level = level;
		this.pids = pids;
		this.parentId = parentId;
		
	}
    public SOMessage() {
    	
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SOMessage setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createdTime);
        int year = calendar.get(Calendar.YEAR);
        //判断是不是今年
        if(Constant.NOW_YEAY ==year ){
        	this.createdTimeStr = DateUtil.dateToString(createdTime, "MM月dd日");
        }else{
        	this.createdTimeStr = DateUtil.dateToString(createdTime, "yyyy年MM月dd日");
        }
        this.createdYMDHMSStr = DateUtil.dateToString(createdTime, "yyyy-MM-dd ahh:mm:ss");//title 显示
        //时间转换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"); 
		this.createdTimeZooe = df.format(createdTime);//带时区的格式化
        return this;
    }

    
    public String getCreatedTimeStr() {
		return createdTimeStr;
	}
	public SOMessage setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
		return this;
	}

    public Integer getLikes() {
        return likes;
    }

    public SOMessage setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public String getAgent() {
        return agent;
    }

    public SOMessage setAgent(String agent) {
        this.agent = agent;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public SOMessage setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getIplocation() {
        return iplocation;
    }

    public SOMessage setIplocation(String iplocation) {
        this.iplocation = iplocation;
        return this;
    }


	public Long getId() {
		return id;
	}
	public SOMessage setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getParentId() {
		return parentId;
	}
	public SOMessage setParentId(Long parentId) {
		this.parentId = parentId;
		return this;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public SOMessage setAuthorId(Long authorId) {
		this.authorId = authorId;
		return this;
	}
	public String getPkey() {
        return pkey;
    }

    public SOMessage setPkey(String pkey) {
        this.pkey = pkey;
        return this;
    }

    public String getReferer() {
        return referer;
    }

    public SOMessage setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SOMessage setMessage(String message) {
        this.message = message;
        return this;
    }
	public String getPids() {
		return pids;
	}
	public SOMessage setPids(String pids) {
		this.pids = pids;
		return this;
	}
	public Integer getLevel() {
		return level;
	}
	public SOMessage setLevel(Integer level) {
		this.level = level;
		return this;
	}
	public String getCreatedYMDHMSStr() {
		return createdYMDHMSStr;
	}
	public void setCreatedYMDHMSStr(String createdYMDHMSStr) {
		this.createdYMDHMSStr = createdYMDHMSStr;
	}
	public String getCreatedTimeZooe() {
		return createdTimeZooe;
	}
	public void setCreatedTimeZooe(String createdTimeZooe) {
		this.createdTimeZooe = createdTimeZooe;
	}
    
}