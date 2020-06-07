package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0024两两交换链表中的节点
 * <p>
 * Data
 * 2020/4/22-21:35
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0024两两交换链表中的节点 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0024两两交换链表中的节点.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of(1, 2, 3, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(2, 1, 4, 3)
        );
    }

    @Code(info = {
            "给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。\n" +
                    "你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。\n" +
                    "示例:\n" +
                    "给定 1->2->3->4, 你应该返回 2->1->4->3.\n"
            , "0ms"
    })
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;


        ListNode ret = new ListNode(0);
        ret.next = head;

        ListNode pre = ret;
        ListNode cur = null;
        ListNode next = null;
        ListNode nextNext = null;

        while (pre.next != null && pre.next.next != null) {
            cur = pre.next;
            next = cur.next;
            nextNext = next.next;

            next.next = cur;
            cur.next = nextNext;
            pre.next = next;

            pre = pre.next.next;
        }

        return ret.next;
    }
}
