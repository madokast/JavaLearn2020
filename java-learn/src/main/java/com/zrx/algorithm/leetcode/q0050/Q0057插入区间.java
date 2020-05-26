package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 插入区间
 * <p>
 * Data
 * 2020/5/26-16:00
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0057插入区间 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0057插入区间.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给出一个无重叠的 ，按照区间起始端点排序的区间列表。

            在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

            示例 1:

            输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
            输出: [[1,5],[6,9]]
            示例 2:

            输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
            输出: [[1,2],[3,10],[12,16]]
            解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/insert-interval
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }
}
