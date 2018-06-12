package com.baozi.service

import com.baozi.po.SOMessageAuthor


/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 * ====
 * <p>
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2017年08月20日 23:32 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@sojson.com
 * @version 1.0<br/>
 *
 */
open interface MessageAuthorService {
     fun deleteByPrimaryKey(id: Long?): Int

     fun insert(entity: SOMessageAuthor): Int

     fun insertSelective(entity: SOMessageAuthor): Int

     fun selectByPrimaryKey(id: Long?): SOMessageAuthor

     fun updateByPrimaryKeySelective(entity: SOMessageAuthor): Int

     fun updateByPrimaryKey(entity: SOMessageAuthor): Int
     fun selectByNickname(nickname: String): Long?

     fun findAll(): List<SOMessageAuthor>

     fun findByOpenId(openId: String): SOMessageAuthor?
}