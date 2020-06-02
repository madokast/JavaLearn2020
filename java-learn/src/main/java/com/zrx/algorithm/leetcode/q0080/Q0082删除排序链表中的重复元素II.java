package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 删除排序链表中的重复元素 II
 * <p>
 * Data
 * 2020/6/2-11:48
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0082删除排序链表中的重复元素II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0082删除排序链表中的重复元素II.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {

        return null;
    }


    @Code(info = """
            给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

            示例 1:

            输入: 1->2->3->3->4->4->5
            输出: 1->2->5
            示例 2:

            输入: 1->1->1->2->3
            输出: 2->3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }
}
