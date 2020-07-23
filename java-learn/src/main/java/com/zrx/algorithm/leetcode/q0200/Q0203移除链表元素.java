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
 * 移除链表元素
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0203移除链表元素 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0203移除链表元素.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2, ListNode.of("1->2->6->3->4->5->6"), 6
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->2->3->4->5")
        );
    }

    @Code(info = """
            删除链表中等于给定值 val 的所有节点。

            示例:

            输入: 1->2->6->3->4->5->6, val = 6
            输出: 1->2->3->4->5
            """)
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(val - 1);
        preHead.next = head;

        ListNode p = preHead;
        ListNode pp = preHead.next;

        while (pp != null) {
            while (pp != null && pp.val == val) {
                pp = pp.next;
            }
            p.next = pp;
            p = pp;
            if (p == null) break;
            pp = pp.next;
        }


        return preHead.next;
    }
}
