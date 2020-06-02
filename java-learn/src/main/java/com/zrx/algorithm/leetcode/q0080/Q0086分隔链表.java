package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 分隔链表
 * <p>
 * Data
 * 2020/6/2-11:52
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0086分隔链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0086分隔链表.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

            你应当保留两个分区中每个节点的初始相对位置。

            示例:

            输入: head = 1->4->3->2->5->2, x = 3
            输出: 1->2->2->4->3->5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/partition-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode partition(ListNode head, int x) {
        return null;
    }
}
