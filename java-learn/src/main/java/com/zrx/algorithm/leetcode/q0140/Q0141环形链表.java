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
 * 环形链表
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0141环形链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0141环形链表.class);

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
        return AnswerFactory.create(
                true, true, false
        );
    }

    @Code(info = """
            给定一个链表，判断链表中是否有环。

            为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

             

            示例 1：

            输入：head = [3,2,0,-4], pos = 1
            输出：true
            解释：链表中有一个环，其尾部连接到第二个节点。


            示例 2：

            输入：head = [1,2], pos = 0
            输出：true
            解释：链表中有一个环，其尾部连接到第一个节点。


            示例 3：

            输入：head = [1], pos = -1
            输出：false
            解释：链表中没有环。


             

            进阶：

            你能用 O(1)（即，常量）内存解决此问题吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/linked-list-cycle
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // 快慢指针法
        ListNode slow = head;
        ListNode fast = head;

        for (; ; ) {
            slow = slow.next;

            ListNode temp = fast.next;
            if (temp == null) return false;
            fast = temp.next;
            if (fast == null) return false;
            if (slow == fast) return true;
        }
    }
}
