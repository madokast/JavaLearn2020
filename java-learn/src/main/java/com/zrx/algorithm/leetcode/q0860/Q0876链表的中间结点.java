package com.zrx.algorithm.leetcode.q0860;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Data
 * 2020/3/23-21:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0876链表的中间结点 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0876链表的中间结点.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create(ListNode.of(1, 2, 3, 4, 5)),
                Input.create(ListNode.of(1, 2, 3, 4, 5, 6))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(ListNode.of(3, 4, 5)),
                Answer.create(ListNode.of(4, 5, 6))
        );
    }

    @Code(info = {"给定一个带有头结点 head 的非空单链表，返回链表的中间结点。",
            "如果有两个中间结点，则返回第二个中间结点。",
            "示例 1：",
            "输入：[1,2,3,4,5]",
            "输出：此列表中的结点 3 (序列化形式：[3,4,5])",
            "返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。",
            "注意，我们返回了一个 ListNode 类型的对象 ans，这样：",
            "ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.",
            "示例 2：",
            "输入：[1,2,3,4,5,6]",
            "输出：此列表中的结点 4 (序列化形式：[4,5,6])",
            "由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。"})
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode mid = head;

        int i = 0;
        while (p != null) {
            i++;
            p = p.next;

            if (i % 2 == 0)
                mid = mid.next;
        }

        return mid;
    }
}
