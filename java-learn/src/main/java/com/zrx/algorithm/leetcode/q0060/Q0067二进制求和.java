package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description
 * 二进制求和
 * <p>
 * Data
 * 2020/5/28-13:56
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0067二进制求和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0067二进制求和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "11", "1",
                "1010", "1011"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("100", "10101");
    }

    @Code(info = """
            给你两个二进制字符串，返回它们的和（用二进制表示）。

            输入为 非空 字符串且只包含数字 1 和 0。

             

            示例 1:

            输入: a = "11", b = "1"
            输出: "100"
            示例 2:

            输入: a = "1010", b = "1011"
            输出: "10101"
             

            提示：

            每个字符串仅由字符 '0' 或 '1' 组成。
            1 <= a.length, b.length <= 10^4
            字符串如果不是 "0" ，就都不含前导零。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/add-binary
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();

        Deque<Integer> ret = new LinkedList<>();

        int carry = 0;

        int ai = al - 1;
        int bi = bl - 1;

        while (ai >= 0 && bi >= 0) {
            int an = a.charAt(ai) - '0';
            int bn = b.charAt(bi) - '0';

            int sum = an + bn + carry;

            if (sum >= 2) {
                ret.addFirst(sum - 2);
                carry = 1;
            } else {
                ret.addFirst(sum);
                carry=0;
            }

            ai--;
            bi--;
        }

        while (ai >= 0) {
            int an = a.charAt(ai) - '0';

            int sum = an + carry;

            if (sum >= 2) {
                ret.addFirst(sum - 2);
                carry = 1;
            } else {
                ret.addFirst(sum);
                carry=0;
            }

            ai--;
        }

        while (bi >= 0) {
            int bn = b.charAt(bi) - '0';

            int sum = bn + carry;

            if (sum >= 2) {
                ret.addFirst(sum - 2);
                carry = 1;
            } else {
                ret.addFirst(sum);
                carry=0;
            }

            bi--;
        }

        if (carry == 1)
            ret.addFirst(1);

        return ret.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
