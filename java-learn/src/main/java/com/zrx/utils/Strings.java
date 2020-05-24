package com.zrx.utils;

import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description
 * Strings 工具类
 * <p>
 * Data
 * 2020/5/24-16:29
 *
 * @author zrx
 * @version 1.0
 */

public class Strings {
    private final static Logger LOGGER = LoggerFactory.getLogger(Strings.class);

    public static String classNameCutDown(int layerNumber, String className) {
        Assert.isTrue(layerNumber >= 1, "层数需要>=1");

        String[] split = className.split("\\.");
        int len = split.length;

        //LOGGER.info("ln={}, cn={},sp={}",layerNumber,className, ToString.apply(split));

        StringBuilder sb = new StringBuilder(className.length());

        int startIndex = len-layerNumber;
        if(startIndex<0)
            return className;
        else {
            for (int i = startIndex; i < len; i++) {
                sb.append(split[i]).append('.');
            }
            sb.delete(sb.length() - 1, sb.length());

            return sb.toString();
        }
    }
}
