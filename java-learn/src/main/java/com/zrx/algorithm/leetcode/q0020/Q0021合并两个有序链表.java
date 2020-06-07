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
 * 合并两个有序链表
 * <p>
 * Data
 * 2020/4/10-23:36
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0021合并两个有序链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0021合并两个有序链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ListNode.of(1, 2, 4), ListNode.of(1, 3, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(1, 1, 2, 3, 4, 4)
        );
    }

    @Code(info = {
            "将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 \n" +
                    "示例：\n" +
                    "输入：1->2->4, 1->3->4\n" +
                    "输出：1->1->2->3->4->4",
            "换成原地合并法"
    })
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        ListNode node = head;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }

            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return head;
    }


    // 这个不是原地合并，不好
    private ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        if (l1 != null)
            currentNode.next = l1;
        else
            currentNode.next = l2;


        return head.next;
    }
}
