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
 * 重排链表
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0143重排链表 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0143重排链表.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
            将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

            你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

            示例 1:

            给定链表 1->2->3->4, 重新排列为 1->4->2->3.
            示例 2:

            给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reorder-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public void reorderList(ListNode head) {

    }
}
