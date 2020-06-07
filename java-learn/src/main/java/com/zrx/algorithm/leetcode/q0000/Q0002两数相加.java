package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * Data
 * 2020/3/29-22:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0002两数相加 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0002两数相加.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4)),
                Input.create(ListNode.of(9), ListNode.of(9)),
                Input.create(null, ListNode.of(9))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(ListNode.of(7, 0, 8)),
                Answer.create(ListNode.of(8, 1)),
                Answer.create(ListNode.of(9))
        );
    }

    @Code(info = {
            "给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字",
            "如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和",
            "您可以假设除了数字 0 之外，这两个数都不会以 0 开头。",
            "示例：",
            "输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)",
            "输出：7 -> 0 -> 8",
            "原因：342 + 465 = 807"
    })
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode empty = new ListNode(0);
        ListNode cur = empty;

        int a1;
        int a2;

        while (carry == 1 || l1 != null || l2 != null) {
            if (l1 == null) a1 = 0;
            else {
                a1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) a2 = 0;
            else {
                a2 = l2.val;
                l2 = l2.next;
            }

            //LOGGER.info("a1 a2 carry = {} {} {}", a1, a2, carry);

            cur.next = new ListNode((a1 + a2 + carry) % 10);
            cur = cur.next;

            carry = (a1 + a2 + carry) / 10;
        }

        return empty.next;
    }
}
