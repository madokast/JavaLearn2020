package com.zrx.algorithm.专题;

import com.zrx.algorithm.专题.专题003.全滑动窗口;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class 全滑动窗口Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(全滑动窗口Test.class);

    int[] arr01 = {4,1,2,2};

    @Test
    void minLength() {
        全滑动窗口 main = new 全滑动窗口();

        int[] ints = main.minLength(arr01);


        LOGGER.info("ints = {}", ints);
    }

    @Test
    void solve(){
        全滑动窗口 main = new 全滑动窗口();

        int[] ints = main.solve(arr01);


        LOGGER.info("ints = {}", ints);
    }
}