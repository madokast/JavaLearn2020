package com.zrx.ichiwanspringboot.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Null;

/**
 * Description
 * 包装数据
 * 用于 JSON 相应
 * <p>
 * Data
 * 2020/3/24-12:36
 *
 * @author zrx
 * @version 1.0
 */

public class DataWrapper<DATA> {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataWrapper.class);

    private static final int SUCCESS = 200;

    private static final int NOT_FOUND = 404;

    private static final int BAD_REQUEST = 400;

    private static final int METHOD_NOT_ALLOWED = 405;

    private static final int NOT_ACCEPTABLE = 406;

    private DATA data;

    private int status;

    private String massage;

    public static <DATA> DataWrapper<DATA> create(String massage, DATA data) {
        return new DataWrapper<>(data, SUCCESS, massage);
    }

    public static  DataWrapper<Null> ok(String massage){
        return new DataWrapper<>(null,SUCCESS,massage);
    }

    public static DataWrapper<Exception> notFound(String massage, Exception e) {
        return new DataWrapper<>(e, NOT_FOUND, massage);
    }

    public static DataWrapper<Exception> badRequest(String massage, Exception e) {
        return new DataWrapper<>(e, BAD_REQUEST, massage);
    }

    public static DataWrapper<Exception> requestMethodNotSupported(String massage, Exception e){
        return new DataWrapper<>(e,METHOD_NOT_ALLOWED,massage);
    }

    public static DataWrapper<Exception> notAcceptable(String massage,Exception e){
        return new DataWrapper<>(e,NOT_ACCEPTABLE,massage);
    }

    public DataWrapper() {
    }

    public DataWrapper(DATA data, int status, String massage) {
        this.data = data;
        this.status = status;
        this.massage = massage;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }


    @Override
    public String toString() {
        return "DataWrapper{" +
                "data=" + data +
                ", status=" + status +
                ", massage='" + massage + '\'' +
                '}';
    }
}
