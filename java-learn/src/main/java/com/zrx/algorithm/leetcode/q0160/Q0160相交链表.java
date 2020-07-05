package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 相交链表
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0160相交链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0160相交链表.class);

    @Override
    public List<Input> getInputs() {
        ListNode l1 = ListNode.of(4, 1);
        ListNode l2 = ListNode.of(5, 0, 1);

        ListNode l3 = ListNode.of(8, 4, 5);
        l1.get(1).next = l3;
        l2.get(2).next = l3;

        ListNode l4 = ListNode.of(0, 9, 1);
        ListNode l5 = ListNode.of(3);
        ListNode l6 = ListNode.of(2, 4);

        l4.get(2).next = l6;
        l5.get(0).next = l6;

        return InputFactory.create(
                2,
                l1, l2,
                l4, l5,
                ListNode.of(1, 2), ListNode.of(1, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
//        ListNode l1 = ListNode.of(4, 1);
//        ListNode l2 = ListNode.of(5, 0, 1);

        ListNode l3 = ListNode.of(8, 4, 5);
//        l1.get(1).next = l3;
//        l2.get(2).next = l3;

//        ListNode l4 = ListNode.of(0, 9, 1);
//        ListNode l5 = ListNode.of(3);
        ListNode l6 = ListNode.of(2, 4);

//        l4.get(2).next = l6;
//        l5.get(0).next = l6;

        return AnswerFactory.create(
                l3, l6, null
        );
    }

    @Code(info = """
            编写一个程序，找到两个单链表相交的起始节点。

            如下面的两个链表：



            在节点 c1 开始相交。

             

            示例 1：



            输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
            输出：Reference of the node with value = 8
            输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
             

            示例 2：



            输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
            输出：Reference of the node with value = 2
            输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
             

            示例 3：



            输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
            输出：null
            输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
            解释：这两个链表不相交，因此返回 null。
             

            注意：

            如果两个链表没有交点，返回 null.
            在返回结果后，两个链表仍须保持原有的结构。
            可假定整个链表结构中没有循环。
            程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1AddS = 0;
        int s2AddS = 0;

        ListNode aNode = headA;
        ListNode bNode = headB;

        while (aNode != null) {
            aNode = aNode.next;
            s1AddS++;
        }

        while (bNode != null) {
            bNode = bNode.next;
            s2AddS++;
        }

        int diff;
        ListNode longList;
        ListNode shortList;

        if (s1AddS > s2AddS) {
            diff = s1AddS - s2AddS;
            longList = headA;
            shortList = headB;
        } else {
            diff = s2AddS - s1AddS;
            longList = headB;
            shortList = headA;
        }

        while (diff > 0) {
            longList = longList.next;
            diff--;
        }

        while (longList != null && shortList != null) {
            if (longList == shortList)
                return longList;
            else {
                longList = longList.next;
                shortList = shortList.next;
            }
        }

        return null;
    }
}
