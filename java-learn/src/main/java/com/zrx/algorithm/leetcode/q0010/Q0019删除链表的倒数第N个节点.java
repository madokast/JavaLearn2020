package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.jar.JarEntry;

/**
 * Description
 * 删除链表的倒数第N个节点
 * <p>
 * Data
 * 2020/4/10-23:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0019删除链表的倒数第N个节点 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0019删除链表的倒数第N个节点.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ListNode.of(1, 2, 3, 4, 5), 2,
                ListNode.of(1), 1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(1, 2, 3, 5),
                ListNode.of()
        );
    }

    @Code(info = {
            "给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。\n" +
                    "示例：\n" +
                    "给定一个链表: 1->2->3->4->5, 和 n = 2.\n" +
                    "当删除了倒数第二个节点后，链表变为 1->2->3->5.\n" +
                    "说明：\n" +
                    "给定的 n 保证是有效的。\n" +
                    "进阶：\n" +
                    "你能尝试使用一趟扫描实现吗？\n"
    })
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = head;

        ListNode previous = head;
        while (n-- > 0)
            head = head.next;

        if (head == null) {
            return head0.next;
        }

        while (head.next != null) {
            head = head.next;
            previous = previous.next;
        }

        previous.next = previous.next.next;

        return head0;
    }
}
