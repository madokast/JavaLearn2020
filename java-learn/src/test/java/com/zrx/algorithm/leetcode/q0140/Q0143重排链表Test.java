package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.leetcode.object.ListNode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Q0143重排链表Test {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0143重排链表Test.class);

    @Autowired
    private Q0143重排链表 q0143重排链表;

    @Test
    public void reverseTest() {
        ListNode node = ListNode.of(1, 2, 3, 4);
        LOGGER.info("node = {}", node);

        ListNode reverse = q0143重排链表.reverse(node);

        LOGGER.info("reverse = {}", reverse);

        Assert.assertEquals(reverse, ListNode.of(4, 3, 2, 1));
    }

    @Test
    public void reverseTest2() {
        ListNode node = ListNode.of(1, 2, 3);
        LOGGER.info("node = {}", node);

        ListNode reverse = q0143重排链表.reverse(node);

        LOGGER.info("reverse = {}", reverse);

        Assert.assertEquals(reverse, ListNode.of(3, 2, 1));
    }


    @Test
    public void reverseTest3() {
        ListNode node = ListNode.of(1, 2);
        LOGGER.info("node = {}", node);

        ListNode reverse = q0143重排链表.reverse(node);

        LOGGER.info("reverse = {}", reverse);

        Assert.assertEquals(reverse, ListNode.of( 2, 1));
    }

    @Test
    public void reverseTest4() {
        ListNode node = ListNode.of(1);
        LOGGER.info("node = {}", node);

        ListNode reverse = q0143重排链表.reverse(node);

        LOGGER.info("reverse = {}", reverse);

        Assert.assertEquals(reverse, ListNode.of(1));
    }
}