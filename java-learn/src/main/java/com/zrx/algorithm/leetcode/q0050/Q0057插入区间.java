package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
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
        return InputFactory.create(
                2,
                ArrayFactory.createTwoDimensionsIntArray(1, 3, null, 6, 9),
                ArrayFactory.create(2, 5),
                ArrayFactory.createTwoDimensionsIntArray(1, 2, null, 3, 5, null, 6, 7, null, 8, 10, null, 12, 16),
                ArrayFactory.create(4, 8),
                ArrayFactory.createTwoDimensionsIntArray(1, 5),
                ArrayFactory.create(2, 7),
                ArrayFactory.createTwoDimensionsIntArray(1, 5),
                ArrayFactory.create(6, 8),
                ArrayFactory.createTwoDimensionsIntArray(1, 5),
                ArrayFactory.create(0, 3),
                ArrayFactory.createTwoDimensionsIntArray(0, 5, null, 9, 12),
                ArrayFactory.create(7, 16)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.createTwoDimensionsIntArray(1, 5, null, 6, 9),
                ArrayFactory.createTwoDimensionsIntArray(1, 2, null, 3, 10, null, 12, 16),
                ArrayFactory.createTwoDimensionsIntArray(1, 7),
                ArrayFactory.createTwoDimensionsIntArray(1, 5, null, 6, 8),
                ArrayFactory.createTwoDimensionsIntArray(0, 5),
                ArrayFactory.createTwoDimensionsIntArray(0, 5, null, 7, 16)
        );
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
        int length = intervals.length;

        if (length == 0)
            return new int[][]{newInterval};

        int left = newInterval[0];
        int right = newInterval[1];

        // 左端点排序
        // 根据问题情况，可以不同排序
        // 排序 3ms，不排序 1ms
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int indexLeft = -2;
        int indexRight = -2;
        boolean leftInIndex = false;
        boolean rightInIndex = false;

        int[] first = intervals[0];

        if (left < first[0]) {
            indexLeft = -1;
        }

        if (right < first[0]) {
            indexRight = -1;
        }

        for (int i = 0; i < length; i++) {
            int[] cur = intervals[i];
            int curLeft = cur[0];
            int curRight = cur[1];

            if (left >= curLeft) {
                indexLeft = i;
                leftInIndex = true;
            }
            if (left > curRight) {
                leftInIndex = false;
            }

            if (right >= curLeft) {
                indexRight = i;
                rightInIndex = true;
            }
            if (right > curRight) {
                rightInIndex = false;
            }

            if(curLeft>right)
                break;
        }

        LOGGER.info("indexLeft = {}", indexLeft);
        LOGGER.info("indexRight = {}", indexRight);
        LOGGER.info("leftInIndex = {}", leftInIndex);
        LOGGER.info("rightInIndex = {}", rightInIndex);

        // 左端点在外部
        if (indexLeft == -1) {
            // 右端点也在
            if (indexRight == -1) {
                int[][] ans = new int[length + 1][];
                ans[0] = newInterval;
                System.arraycopy(intervals, 0, ans, 1, length);
                return ans;
            } else {
                // 右端点在里面
                int[][] ans = new int[length - indexRight][];
                ans[0] = new int[]{left, Math.max(intervals[indexRight][1], right)};
                System.arraycopy(intervals, indexRight + 1, ans, 1, length - indexRight - 1);
                return ans;
            }
            // 左端点在 右边
        } else if (indexLeft == length - 1) {
            if (leftInIndex) {
                if (rightInIndex)
                    return intervals;
                else {
                    int[] last = intervals[length - 1];
                    last[1] = right;
                    return intervals;
                }
            } else {
                int[][] ans = new int[length + 1][];
                ans[length] = newInterval;
                System.arraycopy(intervals, 0, ans, 0, length);
                return ans;
            }
        } else {
            // 左端点在里面
            if (leftInIndex) {
                if (indexRight == indexLeft) {
                    if (rightInIndex)
                        return intervals;
                    else {
                        int[] cur = intervals[indexLeft];
                        cur[1] = right;
                        return intervals;
                    }
                } else {
                    int[][] ans = new int[length - (indexRight - indexLeft)][];
                    System.arraycopy(intervals, 0, ans, 0, indexLeft + 1);
                    ans[indexLeft][1] = Math.max(intervals[indexRight][1], right);
                    System.arraycopy(intervals, indexRight + 1, ans, indexLeft + 1, length - indexRight - 1);
                    return ans;
                }
                // 左端点在外面
            } else {
                if (indexRight == indexLeft) {
                    int[][] ans = new int[length + 1][];
                    System.arraycopy(intervals, 0, ans, 0, indexLeft + 1);
                    ans[indexLeft + 1] = newInterval;
                    System.arraycopy(intervals, indexLeft + 1, ans, indexLeft + 2, length - indexLeft - 1);
                    return ans;
                } else {
                    int[][] ans = new int[length - (indexRight - indexLeft)+1][];
                    System.arraycopy(intervals, 0, ans, 0, indexLeft + 1);
                    ans[indexLeft + 1] = new int[]{left, Math.max(intervals[indexRight][1], right)};
                    System.arraycopy(intervals, indexRight + 1, ans, indexLeft + 2, length - indexRight - 1);
                    return ans;
                }
            }
        }

    }
}
