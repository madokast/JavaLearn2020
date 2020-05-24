package com.zrx.algorithm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2020/5/23-10:37
 *
 * @author zrx
 * @version 1.0
 */


public class ToStringTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(ToStringTest.class);

    @Test
    public void TestArrayToFormatString(){
        int[][] arr = new int[][]{
                {1,2,3},
                {4,5,6}
        };

        LOGGER.info("ToString.arrayToFormatString(arr) = {}", ToString.arrayToFormatString(arr));
    }
}
