package com.zrx.algorithm.leetcode.q0020;

import com.zrx.Invoking;
import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0023合并K个排序链表
 * <p>
 * Data
 * 2020/4/22-21:08
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-22 21:25", info = "Q0023合并K个排序链表")
public class Q0023合并K个排序链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0023合并K个排序链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) new ListNode[]{
                        ListNode.of(1, 4, 5),
                        ListNode.of(1, 3, 4),
                        ListNode.of(2, 6)
                }
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)
        );
    }

    @Code(info = {
            "合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。\n" +
                    "示例:\n" +
                    "输入:\n" +
                    "[\n" +
                    "  1->4->5,\n" +
                    "  1->3->4,\n" +
                    "  2->6\n" +
                    "]\n" +
                    "输出: 1->1->2->3->4->4->5->6\n",
            "9ms"
    })
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        Queue<ListNode> queue = new LinkedList<>();

        Arrays.stream(lists).filter(Objects::nonNull).forEach(queue::offer);

        while (queue.size() > 1) {
            queue.offer(mergeKLists(queue.remove(), queue.remove()));
        }

        return queue.size() == 1 ? queue.remove() : null;
    }

    private ListNode mergeKLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode cur = null;

        if (l1.val < l2.val) {
            ret = l1;
            l1 = l1.next;
        } else {
            ret = l2;
            l2 = l2.next;
        }

        cur = ret;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            // l2!=null
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return ret;
    }


    @Invoking(createdTime = "2020-04-22 21:23", info = "mergeKListsTest")
    public void mergeKListsTest() {
        ListNode l1 = ListNode.of(1, 4, 5);
        ListNode l2 = ListNode.of(1, 3, 4);

        ListNode mergeKLists = mergeKLists(l1, l2);

        LOGGER.info("l2 = {}", l2);
        LOGGER.info("l1 = {}", l1);
        LOGGER.info("mergeKLists = {}", mergeKLists);
    }
}
