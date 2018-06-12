package com.baozi.vo;

/**
 * 用户评论数
 */
public  class UserTips {
	
	private Integer count ;
	
	private Long authorId;

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
}