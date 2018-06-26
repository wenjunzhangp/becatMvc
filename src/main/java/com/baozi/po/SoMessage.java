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
 * @author 张文君
 * @version 1.0,2018年6月15日 19:48 <br/>
 */
public class SoMessage implements Serializable{
	private static final long serialVersionUID = 1434473283877857750L;
	/**评论id**/
	private Long id;
	/**创建时间**/
    private Date createdTime;
    private String createdTimeStr;
    //年月日，时分秒全时间
    private String createdYMDHMSStr;
    //年月日，时分秒全时间，带时区，如：2017-04-26T14:22:27+08:00
    private String createdTimeZooe;
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
    
    public SoMessage(JsonObject jsonObj, Integer level, String pids, Long parentId, Long authorId) {
    	
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
    public SoMessage() {
    	
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public SoMessage setCreatedTime(Date createdTime) {
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
        this.createdYMDHMSStr = DateUtil.dateToString(createdTime, "yyyy-MM-dd ahh:mm:ss");
        //时间转换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        //带时区的格式化
		this.createdTimeZooe = df.format(createdTime);
        return this;
    }

    
    public String getCreatedTimeStr() {
		return createdTimeStr;
	}
	public SoMessage setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
		return this;
	}

    public Integer getLikes() {
        return likes;
    }

    public SoMessage setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public String getAgent() {
        return agent;
    }

    public SoMessage setAgent(String agent) {
        this.agent = agent;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public SoMessage setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getIplocation() {
        return iplocation;
    }

    public SoMessage setIplocation(String iplocation) {
        this.iplocation = iplocation;
        return this;
    }


	public Long getId() {
		return id;
	}
	public SoMessage setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getParentId() {
		return parentId;
	}
	public SoMessage setParentId(Long parentId) {
		this.parentId = parentId;
		return this;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public SoMessage setAuthorId(Long authorId) {
		this.authorId = authorId;
		return this;
	}
	public String getPkey() {
        return pkey;
    }

    public SoMessage setPkey(String pkey) {
        this.pkey = pkey;
        return this;
    }

    public String getReferer() {
        return referer;
    }

    public SoMessage setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SoMessage setMessage(String message) {
        this.message = message;
        return this;
    }
	public String getPids() {
		return pids;
	}
	public SoMessage setPids(String pids) {
		this.pids = pids;
		return this;
	}
	public Integer getLevel() {
		return level;
	}
	public SoMessage setLevel(Integer level) {
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