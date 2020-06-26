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
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return null;
    }
}
