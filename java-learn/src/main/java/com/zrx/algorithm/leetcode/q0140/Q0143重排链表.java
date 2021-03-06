package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.algorithm.leetcode.object.Node;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 重排链表
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */


@Component
public class Q0143重排链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0143重排链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of("1->2->3->4"),
                ListNode.of("1->2->3->4->5")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->4->2->3"),
                ListNode.of("1->5->2->4->3")
        );
    }

    @Code(info = """
            给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
            将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

            你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

            示例 1:

            给定链表 1->2->3->4, 重新排列为 1->4->2->3.
            示例 2:

            给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reorder-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode reorderList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = new ListNode(0);
        slowPre.next = slow;

        while (true) {
            slow = slow.next;
            slowPre = slowPre.next;

            ListNode temp = fast.next;
            if (temp == null) break;
            fast = temp.next;
            if (fast == null) break;
        }
        slowPre.next = null;

        ListNode l1 = head;

        ListNode l2 = reverse(slow);

        boolean l1First = true;

        LOGGER.info("l1 = {}", l1);
        LOGGER.info("l2 = {}", l2);

        while (true) {
            if (l1First) {
                ListNode temp = l1.next;
                l1.next = l2;
                l1 = temp;
                if(temp==null) break;
                l1First = false;
            } else {
                ListNode temp = l2.next;
                l2.next = l1;
                l2 = temp;
                if(temp==null) break;
                l1First = true;
            }
        }

        return head;
    }

    /**
     * 翻转链表
     *
     * @param head 头
     * @return 翻转后链表
     */
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;

        while (next != null) {
            ListNode nn = next.next;

            next.next = cur;


            cur = next;
            next = nn;
        }


        return cur;
    }
}
