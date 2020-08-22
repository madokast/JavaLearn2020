package com.zrx.fragment.Others;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class 单调栈Test {
    private final static Logger LOGGER = LoggerFactory.getLogger(单调栈Test.class);

    private final int[] arr01 = {4,1,2,2};

    @Test
    public void indexTest(){
        单调栈 main = new 单调栈();

        int[] index = main.index(arr01);

        LOGGER.info("index = {}", index);
    }

}