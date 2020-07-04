package com.zrx.algorithm.leetcode.q0150;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Description
 * 翻转字符串里的单词
 * <p>
 * Data
 * 2020/7/2-21:59
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0151翻转字符串里的单词 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0151翻转字符串里的单词.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "the sky is blue",
                "  hello world!  ",
                "a good  example"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "blue is sky the",
                "world! hello",
                "example good a"
        );
    }

    @Code(info = """
            给定一个字符串，逐个翻转字符串中的每个单词。

             

            示例 1：

            输入: "the sky is blue"
            输出: "blue is sky the"
            示例 2：

            输入: "  hello world!  "
            输出: "world! hello"
            解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
            示例 3：

            输入: "a good   example"
            输出: "example good a"
            解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
             

            说明：

            无空格字符构成一个单词。
            输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
            如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
             

            进阶：

            请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");

        LOGGER.info("split = {}", ToString.arrayToFormatString(split));
        StringBuilder sb = new StringBuilder();


        for (int i = split.length - 1; i >= 0; i--) {
            String ss = split[i];
            sb.append(ss);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
