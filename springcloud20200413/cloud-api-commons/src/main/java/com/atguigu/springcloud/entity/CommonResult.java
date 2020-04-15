package com.atguigu.springcloud.entity;

import java.io.Serializable;

/**
 * Description
 * CommonResult
 * Json boxer
 * <p>
 * Data
 * 2020/4/13-20:52
 *
 * @author zrx
 * @version 1.0
 */

public class CommonResult<T> implements Serializable {

    private static Integer SUCCESS = 200;
    private static Integer NOT_FOUND = 404;

    private Integer code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(String message,T data){
        return new CommonResult<>(SUCCESS,message,data);
    }

    public static <T> CommonResult<T> notFound(String message,T data){
        return new CommonResult<>(NOT_FOUND,message,data);
    }



    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
