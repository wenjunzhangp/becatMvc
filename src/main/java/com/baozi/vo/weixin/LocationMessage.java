package com.baozi.vo.weixin;

import lombok.Data;

/**
 * Copyright:   互融云
 * 微信位置类型信息交互实体类
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 17:34
 */
@Data
public class LocationMessage extends BaseMessage {

    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;

}
