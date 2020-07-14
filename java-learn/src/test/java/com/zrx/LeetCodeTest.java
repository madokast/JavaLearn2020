package com.zrx;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.q0000.Q0001两数之和;
import com.zrx.algorithm.leetcode.q0860.Q0876链表的中间结点;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LeetCodeTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(LeetCodeTest.class);

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void test() {
        Q0001两数之和 q0001两数之和 = new Q0001两数之和();
        q0001两数之和.run();

        new Q0876链表的中间结点().run();
    }

    @Test
    public void allQuestion() {
        ioc.getBeansOfType(Question.class, false, true)
                .values()
                .forEach(Question::run);
    }

}
