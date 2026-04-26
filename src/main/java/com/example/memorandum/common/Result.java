package com.example.memorandum.common;


import lombok.Data;

/**
 * 统一返回结果类
 * 简化版，用于前后端数据交互的统一格式
 */
@Data
public class Result {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 消息
     */
    private String message;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private Object data;

    /**
     * 私有构造方法，禁止外部直接创建
     */
    private Result() {}

    /**
     * 成功返回（无数据）
     */
    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 成功返回（有数据）
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 成功返回（带消息）
     */
    public static Result success(String message, Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回
     */
    public static Result error(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败返回（带状态码）
     */
    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


}
