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
 * 删除链表中的节点
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0237删除链表中的节点 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0237删除链表中的节点.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ListNode.of(1, 2, 3, 4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                deleteNode(ListNode.of(1, 2, 3, 4))
        );
    }

    @Code(info = """
            请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

             

            现有一个链表 -- head = [4,5,1,9]，它可以表示为:



             

            示例 1：

            输入：head = [4,5,1,9], node = 5
            输出：[4,1,9]
            解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
            示例 2：

            输入：head = [4,5,1,9], node = 1
            输出：[4,5,9]
            解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
             

            提示：

            链表至少包含两个节点。
            链表中所有节点的值都是唯一的。
            给定的节点为非末尾节点并且一定是链表中的一个有效节点。
            不要从你的函数中返回任何结果。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

        return node;
    }
}
