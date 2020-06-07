package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0025K个一组翻转链表
 * <p>
 * Data
 * 2020/5/11-15:01
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0025K个一组翻转链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0025K个一组翻转链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ListNode.of(1, 2, 3, 4, 5), 2,
                ListNode.of(1, 2, 3, 4, 5), 3,
                ListNode.of(1, 2), 2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(2, 1, 4, 3, 5),
                ListNode.of(3, 2, 1, 4, 5),
                ListNode.of(2, 1)
        );
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    @Code(info = {
            """
                    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
                    k 是一个正整数，它的值小于或等于链表的长度。
                    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
                    示例：
                    给你这个链表：1->2->3->4->5
                    当 k = 2 时，应当返回: 2->1->4->3->5
                    当 k = 3 时，应当返回: 3->2->1->4->5
                    说明：
                    你的算法只能使用常数的额外空间。
                    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
                    """}
    )
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        ListNode pre = null;
        ListNode first = head;
        ListNode last = next(first, k - 1);

        head = null;

        while (last != null) {
            reverse(pre, first, last);

            if (head == null) {
                head = last;
            }

            pre = first;
            first = pre.next;

            last = next(first, k - 1);
        }

        return head == null ? first : head;
    }

    /**
     * 返回当前元素之后，第k个元素
     * 如果不存在，则返回 null
     *
     * @param node 当前节点
     * @param k    k个
     * @return 当前元素之后，第k个元素
     */
    public ListNode next(ListNode node, int k) {
        //LOGGER.info("{},{}", node.val, k);

        if (node == null)
            return null;

        while (k > 0) {
            node = node.next;
            if (node == null) {
                return null;
            }

            k--;
        }

        return node;
    }

    /**
     * 翻转链表种 first->...->last 的一段
     *
     * @param pre   first的前一个元素 可空
     * @param first 要反转的第一个元素
     * @param last  要翻转的第二个元素 不能是last
     */
    private void reverse(ListNode pre, ListNode first, ListNode last) {
        //LOGGER.info("{},{}", first.val, last.val);


        if (pre != null) {
            pre.next = last;
        }


        ListNode cur = first;
        ListNode curNext = first.next;
        ListNode curNextNext = curNext.next;

        first.next = last.next;

        while (true) {
            curNext.next = cur;

            cur = curNext;

            if (cur == last)
                break;

            curNext = curNextNext;
            curNextNext = curNext.next;

        }

    }
}
