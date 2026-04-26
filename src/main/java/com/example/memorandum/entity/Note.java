package com.example.memorandum.entity;

import lombok.Data;

import java.util.Date;

/**
 * 备忘录实体类
 * 对应note表
 */
@Data
public class Note {

    /**
     * 备忘录ID
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 分类
     */
    private String category;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户ID
     */
    private Integer userId;
}
