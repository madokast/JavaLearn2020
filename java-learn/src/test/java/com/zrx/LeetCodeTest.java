package com.zrx;

import com.zrx.algorithm.leetcode.q0000.Q0001两数之和;
import com.zrx.algorithm.leetcode.q0860.Q0876链表的中间结点;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description
 * LeetCodeTest
 * <p>
 * Data
 * 2020/3/23-18:05
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootTest
public class LeetCodeTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(LeetCodeTest.class);

    @Test
    public void test() {
        Q0001两数之和 q0001两数之和 = new Q0001两数之和();
        q0001两数之和.run();

        new Q0876链表的中间结点().run();
    }

}
