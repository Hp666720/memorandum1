package com.example.memorandum.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * 对应user表
 */
@Data
public class User {

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;


}
