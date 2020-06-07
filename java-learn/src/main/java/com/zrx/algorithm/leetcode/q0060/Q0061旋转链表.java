package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 旋转链表
 * <p>
 * Data
 * 2020/5/28-13:23
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0061旋转链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0061旋转链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ListNode.of(1,2,3,4,5),2,
                ListNode.of(0,1,2),4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(4,5,1,2,3),
                ListNode.of(2,0,1)
        );
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    @Code(info = """
            给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

            示例 1:

            输入: 1->2->3->4->5->NULL, k = 2
            输出: 4->5->1->2->3->NULL
            解释:
            向右旋转 1 步: 5->1->2->3->4->NULL
            向右旋转 2 步: 4->5->1->2->3->NULL
            示例 2:

            输入: 0->1->2->NULL, k = 4
            输出: 2->0->1->NULL
            解释:
            向右旋转 1 步: 2->0->1->NULL
            向右旋转 2 步: 1->2->0->NULL
            向右旋转 3 步: 0->1->2->NULL
            向右旋转 4 步: 2->0->1->NULL

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/rotate-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null)
            return head;

        if(k==0)
            return head;


        int length = length(head);
        LOGGER.info("length = {}", length);

        k = length - k % length - 1;

        ListNode node = head;

        while (k > 0) {
            node = node.next;
            k--;
        }

        LOGGER.info("node = {}", node);

        ListNode tail = node;
        while (tail.next != null)
            tail = tail.next;

        LOGGER.info("tail = {}", tail);

        tail.next = head;

        ListNode newHead = node.next;

        node.next = null;

        return newHead;
    }

    private int length(ListNode head) {
        if(head==null)
            return 0;

        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }

        return len;
    }
}
