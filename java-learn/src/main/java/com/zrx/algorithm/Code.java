package com.zrx.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description
 * Code 算法类入口
 * <p>
 * Data
 * 2020/6/6-16:46
 *
 * @author zrx
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Code {
    String[] info() default {};

    int[] printInputParameters() default {};

    // 以下两个注解共同定位一个问题

    String group() default QuestionWrapper.LEETCODE;

    int number() default 1;
}
