package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 反转链表
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0206反转链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0206反转链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, ListNode.of("1->2->3->4->5")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("5->4->3->2->1")
        );
    }

    @Code(info = """
            反转一个单链表。

            示例:

            输入: 1->2->3->4->5->NULL
            输出: 5->4->3->2->1->NULL
            进阶:
            你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-linked-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;

        ListNode cur = pre.next;
        if (cur == null) return pre;

        pre.next = null;

        ListNode next = cur.next;
        while (next != null) {

            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }

        cur.next = pre;

        return cur;
    }
}
