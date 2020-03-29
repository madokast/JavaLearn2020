package com.zrx.ichiwanspringboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * ValidationFailedException
 * <p>
 * Data
 * 2020/3/25-17:29
 *
 * @author zrx
 * @version 1.0
 */

public class ValidationFailedException extends Exception{
    private final static Logger LOGGER = LoggerFactory.getLogger(ValidationFailedException.class);

    public ValidationFailedException(String msg){
        //@param   message   the detail message. The detail message is saved for
        //     *          later retrieval by the {@link #getMessage()} method.
        super(msg);
    }
}
