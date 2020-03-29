package com.zrx.ichiwanspringboot.exception;

import com.zrx.ichiwanspringboot.bean.DataWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Description
 * 全局异常处理
 * <p>
 * Data
 * 2020/3/24-14:48
 *
 * @author zrx
 * @version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public GlobalExceptionHandler() {
        LOGGER.info("GlobalExceptionHandler injected");
    }

    @ExceptionHandler(Exception.class)
    public DataWrapper<Exception> badRequest(Exception e) {
        LOGGER.error("发生未知异常，请分类。{}", e.toString());
        return DataWrapper.badRequest("未知异常", e);
    }

    /**
     * 处理spring默认处理的 404 not found 请求
     * 需要配置文件
     * # catch the 404 not found exception, otherwise it will be handled by springboot itself
     * spring.mvc.throw-exception-if-no-handler-found=true
     * spring.resources.add-mappings=false
     *
     * @param e 异常
     * @return badRequest
     */
    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    public DataWrapper<Exception> noHandlerFound(org.springframework.web.servlet.NoHandlerFoundException e) {
        LOGGER.warn("NoHandlerFoundException = {}", e.getMessage());
        return DataWrapper.badRequest(e.getMessage(), e);
    }

    /**
     * 请求不支持
     * 如某个url只支持 POST 方法，而收到了 GET 请求
     * 就会抛出此异常
     *
     * @param e HttpRequestMethodNotSupportedException
     * @return requestMethodNotSupported
     */
    @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
    public DataWrapper<Exception> httpRequestMethodNotSupported(org.springframework.web.HttpRequestMethodNotSupportedException e) {
        LOGGER.warn("HttpRequestMethodNotSupportedException = {}", e.getMessage());
        return DataWrapper.requestMethodNotSupported(e.getMessage(), e);
    }

    /**
     * 验证不通过异常
     * 如收到的某个字段为空
     *
     * @param e ValidationFailedException
     * @return notAcceptable
     */
    @ExceptionHandler({ValidationFailedException.class})
    public DataWrapper<Exception> validationFailed(ValidationFailedException e) {
        LOGGER.warn("ValidationFailedException = {}", e.getMessage());
        return DataWrapper.notAcceptable(e.getMessage(), e);
    }

    /**
     * 请求参数有误
     * @param e BadRequestParameterException
     * @return badRequest
     */
    @ExceptionHandler(BadRequestParameterException.class)
    public DataWrapper<Exception> badRequestParameter(BadRequestParameterException e) {
        LOGGER.warn("BadRequestParameterException = {}", e.getMessage());
        return DataWrapper.badRequest(e.getMessage(), e);
    }

}
