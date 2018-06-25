package com.baozi.po;

import lombok.Data;

@Data
public class MessageLike {
    private Long id;

    private Long messageId;

    private Long userId;

    private String ip;

}