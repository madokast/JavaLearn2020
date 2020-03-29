package com.zrx.ichiwanspringboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * BadRequestParameterException
 * 请求参数有误异常
 * <p>
 * Data
 * 2020/3/25-20:09
 *
 * @author zrx
 * @version 1.0
 */

public class BadRequestParameterException extends Exception{
    private final static Logger LOGGER = LoggerFactory.getLogger(BadRequestParameterException.class);

    public BadRequestParameterException(String msg){
        super(msg);
    }
}
