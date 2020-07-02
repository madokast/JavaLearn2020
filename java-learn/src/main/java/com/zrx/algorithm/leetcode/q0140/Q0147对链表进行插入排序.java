package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 对链表进行插入排序
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0147对链表进行插入排序 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0147对链表进行插入排序.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of("4->2->1->3"),
                ListNode.of("-1->5->3->4->0")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->2->3->4"),
                ListNode.of("-1->0->3->4->5")
        );
    }

    @Code(info = """
            对链表进行插入排序。


            插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
            每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

             

            插入排序算法：

            插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
            每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
            重复直到所有输入数据插入完为止。
             

            示例 1：

            输入: 4->2->1->3
            输出: 1->2->3->4
            示例 2：

            输入: -1->5->3->4->0
            输出: -1->0->3->4->5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/insertion-sort-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        return insertionSortList(head, head);
    }

    private ListNode insertionSortList(ListNode head, ListNode pre) {
        LOGGER.info("head = {}, pre = {}", head, pre);
        if (pre.next == null) return head;

        ListNode node = pre.next;
        if (pre.val <= node.val) { // order
            return insertionSortList(head, node);
        } else {
            pre.next = node.next;

            if (node.val <= head.val) {
                node.next = head;
                return insertionSortList(node, pre);
            } else {
                for (ListNode n = head; ; n = n.next) {
                    if (node.val <= n.next.val) {
                        node.next = n.next;
                        n.next = node;
                        return insertionSortList(head, pre);
                    }
                }
            }
        }
    }
}
