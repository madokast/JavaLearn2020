package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 回文链表
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0234回文链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0234回文链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of(1, 2),
                ListNode.of(1, 2, 1),
                ListNode.of(1, 2, 2, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                false, true, true
        );
    }

    @Code(info = """
            请判断一个链表是否为回文链表。

            示例 1:

            输入: 1->2
            输出: false
            示例 2:

            输入: 1->2->2->1
            输出: true
            进阶：
            你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/palindrome-linked-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        int len = 0;

        while (true) {
            fast = fast.next;
            len++;
            if (fast == null) break;
            fast = fast.next;
            len++;
            if (fast == null) break;

            slow = slow.next;
        }

        if (len == 1) return true;


        // len = 2n+1 slow = n-1
        // len = 2n   slow = n-1

        ListNode reversed = reverse(slow.next);

        len = len/2;
        for (int i = 0; i < len; i++) {
            if(head.val!=reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    private ListNode reverse(ListNode slow) {
        if (slow == null) return null;

        ListNode pre = null;
        ListNode cur = slow;
        ListNode post = slow.next;

        while (post != null) {
            cur.next = pre;

            pre = cur;
            cur = post;
            post = post.next;
        }

        cur.next = pre;

        LOGGER.info("cur = {}", cur);

        return cur;
    }
}
