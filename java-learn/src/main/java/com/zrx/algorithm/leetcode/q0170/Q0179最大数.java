package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * Q0179最大数
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0179最大数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0179最大数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(10, 2),
                ArrayFactory.create(3, 30, 34, 5, 9),
                ArrayFactory.create(824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247),
                ArrayFactory.create(12, 121),
                ArrayFactory.create(3, 30, 34, 5, 9)
        );
    }

    //  9609  938  824  8247  69735703560743981399  answer
    //  9609  938  8247  824  69735703560743981399  ret

    //  12  121  answer
    //  121 12   ret

    //  95  34  3  30  ans
    //  95  3  34  30  ret

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "210", "9534330",
                "9609938824824769735703560743981399",
                "12121",
                "9534330"
        );
    }

    @Code(info = """
            给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

            示例 1:

            输入: [10,2]
            输出: 210
            示例 2:

            输入: [3,30,34,5,9]
            输出: 9534330
            说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/largest-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.toList());
        Collections.sort(
                list,
                (s1, s2) -> {
//                    int i = 0;
//                    int j = 0;
//                    while (i < s1.length() && j < s2.length()) {
//                        char ci = s1.charAt(i);
//                        char cj = s2.charAt(j);
//                        if (ci > cj) return -1;
//                        if (ci < cj) return 1;
//
//                        i++;
//                        j++;
//                    }

                    return (s2 + s1).compareTo(s1 + s2);
                }
        );


        String ans = String.join("", list);

        return ans.charAt(0) == '0' ? "0" : ans;
    }
}
