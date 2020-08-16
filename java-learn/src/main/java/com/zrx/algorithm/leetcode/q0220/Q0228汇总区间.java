package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * 汇总区间
 * 遍历即可
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0228汇总区间 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0228汇总区间.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(0, 1, 2, 4, 5, 7),
                ArrayFactory.create(0, 2, 3, 4, 6, 8, 9)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of("0->2", "4->5", "7"),
                List.of("0", "2->4", "6", "8->9")
        );
    }

    @Code(info = """
            给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

            示例 1:

            输入: [0,1,2,4,5,7]
            输出: ["0->2","4->5","7"]
            解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
            示例 2:

            输入: [0,2,3,4,6,8,9]
            输出: ["0","2->4","6","8->9"]
            解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/summary-ranges
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> summaryRanges(int[] nums) {
        List<StringBuilder> ans = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (ans.isEmpty()) ans.add(new StringBuilder(String.valueOf(num)));
            else {
                StringBuilder last = ans.get(ans.size() - 1);

                int arr = last.indexOf(">");

                int lastNumber;
                if (arr == -1) lastNumber = Integer.parseInt(last.toString());
                else lastNumber = Integer.parseInt(last.substring(arr + 1, last.length()));


                if (num - lastNumber == 1) combine(last, num);
                else ans.add(new StringBuilder(String.valueOf(num)));
            }
        }

        return ans.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    private void combine(StringBuilder last, int num) {
        int arr = last.indexOf(">");
        if (arr == -1) last.append("->").append(num);
        else last.replace(arr + 1, last.length(), String.valueOf(num));
    }
}
