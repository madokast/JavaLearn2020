package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0056合并区间
 * <p>
 * Data
 * 2020/5/26-15:58
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0056合并区间 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0056合并区间.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.createTwoDimensionsIntArray(1, 3, null, 2, 6, null, 8, 10, null, 15, 18),
                ArrayFactory.createTwoDimensionsIntArray(1, 4, null, 4, 5)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.createTwoDimensionsIntArray(1, 6, null, 8, 10, null, 15, 18),
                ArrayFactory.createTwoDimensionsIntArray(1, 5)
        );
    }

    @Code(info = """
            给出一个区间的集合，请合并所有重叠的区间。

            示例 1:

            输入: [[1,3],[2,6],[8,10],[15,18]]
            输出: [[1,6],[8,10],[15,18]]
            解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
            示例 2:

            输入: [[1,4],[4,5]]
            输出: [[1,5]]
            解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/merge-intervals
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> answer = new Stack<>();

        answer.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];

            int[] peek = answer.peek();
            if(peek[1]>=cur[0]){
                if(peek[1]<cur[1]){
                    answer.pop();
                    answer.push(new int[]{peek[0],cur[1]});
                }
            }else
                answer.push(cur);

        }

        return answer.toArray(int[][]::new);
    }
}
