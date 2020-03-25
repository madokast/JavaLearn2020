package com.zrx.io;

import com.zrx.algorithm.QuestionWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

    public GlobalExceptionHandler(){
        LOGGER.info("GlobalExceptionHandler injected");
    }

    @ExceptionHandler(Exception.class)
    public DataWrapper<Exception> badRequest(Exception e) {
        LOGGER.error("发生未知异常，请分类。{}",e.toString());
        return DataWrapper.badRequest("未知异常", e);
    }

    /**
     * 处理spring默认处理的 404 not found 请求
     * 需要配置文件
     * # catch the 404 not found exception, otherwise it will be handled by springboot itself
     * spring.mvc.throw-exception-if-no-handler-found=true
     * spring.resources.add-mappings=false
     * @param e 异常
     * @return badRequest
     */
    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    public DataWrapper<Exception> noHandlerFound(Exception e){
        return DataWrapper.badRequest("请求错误",e);
    }


    /**
     *
     * @param e 没有找到对于的 question 异常
     * @return not found
     */
    @ExceptionHandler(QuestionWrapper.QuestionWrapperNotFoundException.class)
    public DataWrapper<Exception> questionWrapperNotFound(Exception e){
        return DataWrapper.notFound("question不存在",e);
    }

    /**
     *
     * @param e 没有正在运行的 question 异常
     * @return not found
     */
    @ExceptionHandler(QuestionWrapper.NoRunningQuestionException.class)
    public DataWrapper<Exception> noRunningQuestion(Exception e){
        return DataWrapper.notFound("没有正在运行的question",e);
    }

}
