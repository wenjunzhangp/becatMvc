package com.baozi.service.impl;

import com.baozi.mappers.PetMapper;
import com.baozi.po.PetExample;
import com.baozi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenjun.zhang
 * @create 2018-03-07 15:16
 * @description 宠物逻辑操作类
 **/
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetMapper petMapper;

    @Override
    public int findAllPetCount() {
        PetExample petExample=new PetExample();
        return petMapper.countByExample(petExample);
    }
}
