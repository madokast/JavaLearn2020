package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 解码方法
 * <p>
 * Data
 * 2020/6/6-16:27
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0091解码方法 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0091解码方法.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "12",
                "226",
                "0",
                "1010",
                "01",
                "00",
                "001"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                2, 3, 0, 1, 0, 0, 0
        );
    }

    @Code(info = """
            一条包含字母 A-Z 的消息通过以下方式进行了编码：

            'A' -> 1
            'B' -> 2
            ...
            'Z' -> 26
            给定一个只包含数字的非空字符串，请计算解码方法的总数。

            示例 1:

            输入: "12"
            输出: 2
            解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
            示例 2:

            输入: "226"
            输出: 3
            解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/decode-ways
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numDecodings(String s) {
        if (s == null) return 0;

        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0) return 0;
        if (length == 1) return chars[0] == '0' ? 0 : 1;

        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;

        for (int i = 1; i < length; i++) {

            char c = chars[i];

            if (c != '0') dp[i + 1] += dp[i];

            char pc = chars[i - 1];

            if (pc == '1' || (pc == '2' && c <= '6')) dp[i + 1] += dp[i - 1];
        }

        return dp[length];
    }
}
