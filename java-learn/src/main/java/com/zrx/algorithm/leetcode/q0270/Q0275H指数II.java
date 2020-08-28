package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * H 指数 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0275H指数II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0275H指数II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(0, 1, 3, 5, 6)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3
        );
    }

    @Code(info = """
            给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。

            h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"

             

            示例:

            输入: citations = [0,1,3,5,6]
            输出: 3\040
            解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
                 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
             

            说明:

            如果 h 有多有种可能的值 ，h 指数是其中最大的那个。

             

            进阶：

            这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
            你可以优化你的算法到对数时间复杂度吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/h-index-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int hIndex(int[] citations) {

        int length = citations.length;
        if (length == 0) return 0;

        if (citations[length - 1] == 0) return 0;

        int left = 1;
        int right = length;

        while (left <= right) {
            int mid = (left + right) / 2;

            int midBig = citations[length - mid];
            int othersBig = length - mid == 0 ? -1 : citations[length - mid - 1];
            if (midBig >= mid && othersBig <= mid) {
                return mid;
            } else if (midBig < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
