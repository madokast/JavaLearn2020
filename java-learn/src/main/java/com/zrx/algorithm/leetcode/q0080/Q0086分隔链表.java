package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 分隔链表
 * <p>
 * Data
 * 2020/6/2-11:52
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0086分隔链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0086分隔链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ListNode.of("1->4->3->2->5->2"), 3,
                ListNode.of(2, 1), 2,
                ListNode.of(1, 2, 3), 4,
                ListNode.of(3, 1, 2), 3,
                ListNode.of(3, 3, 1, 2, 4), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->2->2->4->3->5"),
                ListNode.of(1, 2),
                ListNode.of(1, 2, 3),
                ListNode.of(1, 2, 3),
                ListNode.of(1, 2, 3, 3, 4)
        );
    }

    @Code(info = """
            给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

            你应当保留两个分区中每个节点的初始相对位置。

            示例:

            输入: head = 1->4->3->2->5->2, x = 3
            输出: 1->2->2->4->3->5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/partition-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode p0, p;
        p = new ListNode(0);
        p.next = head;
        p0 = p;


        while (head != null && head.val < x) {
            p = head;
            head = head.next;
        }
        if (head == null) return p0.next;


        ListNode pre = p;
        while (head != null) {
            if (head.val < x) {
                pre.next = head.next;
                head.next = p.next;
                p.next = head;
                p = head;
            }

            pre = head;
            head = head.next;
        }

        return p0.next;
    }
}
