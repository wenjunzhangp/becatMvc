package com.baozi.po;

import lombok.Data;

import java.util.Date;

@Data
public class SysSetting {
    private Integer id;

    private String currentVersion;

    private String author;

    private String domainUrl;

    private String serverConfig;

    private String databaseVersion;

    private String maxFile;

    private Date createtime;

    private Date lastModifyTime;

    private String domainName;

    private String icpcard;

    private String description;

    private String keywords;

    private String copyright;

}