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
 * 排序链表
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0148排序链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0148排序链表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of("4->2->1->3"),
                ListNode.of("-1->5->3->4->0"),
                ListNode.of("1"),
                ListNode.of(3, 2, 1)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ListNode.of("1->2->3->4"),
                ListNode.of("-1->0->3->4->5"),
                ListNode.of(1),
                ListNode.of(1, 2, 3)
        );
    }

    @Code(info = """
            在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

            示例 1:

            输入: 4->2->1->3
            输出: 1->2->3->4
            示例 2:

            输入: -1->5->3->4->0
            输出: -1->0->3->4->5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/sort-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode sortList(ListNode head) {
        // 归并排序 非递归法
        if (head == null) return null;


//        // 是否继续分段
//        boolean cut = true;

//        int length = 0; // 链表长度
//        ListNode t = head;
//        while (t != null) {
//            t = t.next;
//            length++;
//        }

        for (int partLength = 2; ; partLength <<= 1) {
            LOGGER.info("head = {}", head);
            LOGGER.info("partLength = {}", partLength);

            // partLength 分段长度

            int orderedLength = partLength >> 1; // 有序长度
            LOGGER.info("orderedLength = {}", orderedLength);

            ListNode curHeadPre = new ListNode(0);

            curHeadPre.next = head;

            int cutTime = 0;
            while (curHeadPre.next != null) {
                LOGGER.info("head = {}", head);
                LOGGER.info("curHeadPre1 = {}", curHeadPre);
                cutTime++;
                ListNode curHeadPreSave = curHeadPre;
                ListNode part1 = curHeadPre.next;
                ListNode part2 = null;

                int len = 0;
                while (len < orderedLength && curHeadPre != null) {
                    curHeadPre = curHeadPre.next;
                    len++;
                }

                if (curHeadPre == null) break;
                part2 = curHeadPre.next;

                len = 0;
                while (len < orderedLength && curHeadPre != null) {
                    curHeadPre = curHeadPre.next;
                    len++;
                }

                //if (curHeadPre == null) break;
                ListNode curHead = curHeadPre == null ? null : curHeadPre.next;

                LOGGER.info("curHeadPre2 = {}", curHeadPre);

                // 现在 part1  - part2 有序
                LOGGER.info("part1 = {}", part1);
                LOGGER.info("part2 = {}", part2);
                int part1Len = 0;
                int part2Len = 0;
                ListNode pre = new ListNode(0);
                ListNode t = pre;
                while (part1Len < orderedLength && part2Len < orderedLength && part2 != null) {
                    if (part1.val <= part2.val) {
                        t.next = part1;
                        t = t.next;
                        part1 = part1.next;
                        part1Len++;
                    } else {
                        t.next = part2;
                        t = t.next;
                        part2 = part2.next;
                        part2Len++;
                    }
                }

                while (part1Len < orderedLength) {
                    t.next = part1;
                    t = t.next;
                    part1 = part1.next;
                    part1Len++;
                }

                while (part2Len < orderedLength && part2 != null) {
                    t.next = part2;
                    t = t.next;
                    part2 = part2.next;
                    part2Len++;
                }

                curHeadPreSave.next = pre.next;
                if (cutTime == 1) head = pre.next;

                t.next = curHead;
                curHeadPre = t;

                LOGGER.info("t = {}", t);
            }

            if (cutTime == 1) break;
        }


        return head;
    }
}
