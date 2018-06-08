package com.baozi.service;


/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:14
 * @description 宠物相关service
 **/
public interface PetService {

    /**
     * 获取平台在售宠物总数
     * @return
     */
    int findAllPetCount();
}
