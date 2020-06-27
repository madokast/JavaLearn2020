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
 * 环形链表 II
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0142环形链表II implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0142环形链表II.class);

    @Override
    public List<Input> getInputs() {
        ListNode l1 = ListNode.of(3, 2, 0, 4);
        l1.get(3).next = l1.get(1);
        ListNode l2 = ListNode.of(1, 2);
        l2.get(1).next = l2;
        return InputFactory.create(
                1,
                l1,
                l2,
                ListNode.of(1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
//        ListNode l1 = ListNode.of(3, 2, 0, 4);
//        l1.get(3).next = l1.get(1);
//        ListNode l2 = ListNode.of(1, 2);
//        l2.get(1).next = l2;
//        return AnswerFactory.create(
//                l1.get(1), l2.get(0), null
//        );

        return AnswerFactory.create(
                1, 0, -1
        );
    }

    @Code(info = """
            给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

            为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

            说明：不允许修改给定的链表。

             

            示例 1：

            输入：head = [3,2,0,-4], pos = 1
            输出：tail connects to node index 1
            解释：链表中有一个环，其尾部连接到第二个节点。


            示例 2：

            输入：head = [1,2], pos = 0
            输出：tail connects to node index 0
            解释：链表中有一个环，其尾部连接到第一个节点。


            示例 3：

            输入：head = [1], pos = -1
            输出：no cycle
            解释：链表中没有环。


             

            进阶：
            你是否可以不用额外空间解决此题？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public Integer detectCycle(ListNode head) {
        if (head == null) return -1;

        // 快慢指针法
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;

            ListNode temp = fast.next;
            if (temp == null) return -1;
            fast = temp.next;
            if (fast == null) return -1;
        } while (slow != fast);

        // slow == fast

        slow = head;
        int pos = 0;
        while (slow != fast) {
            pos++;
            slow = slow.next;
            fast = fast.next;
        }

        return pos;
    }


    //        if (head == null) return false;
    //
    //        // 快慢指针法
    //        ListNode slow = head;
    //        ListNode fast = head;
    //
    //        for (; ; ) {
    //            slow = slow.next;
    //
    //            ListNode temp = fast.next;
    //            if (temp == null) return false;
    //            fast = temp.next;
    //            if (fast == null) return false;
    //            if (slow == fast) return true;
    //        }
}
