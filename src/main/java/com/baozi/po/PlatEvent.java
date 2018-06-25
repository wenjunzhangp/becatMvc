package com.baozi.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PlatEvent {
    private Integer id;

    private String title;

    private Date edate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private Integer status;

    private Integer display;

    private String content;

}