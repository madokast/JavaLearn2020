package com.zrx.algorithm.leetcode.q0050;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最后一个单词的长度
 * <p>
 * Data
 * 2020/5/26-16:00
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0058最后一个单词的长度 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0058最后一个单词的长度.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "Hello World",
                "a ",
                "a  b  "
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(5, 1, 1);
    }

    @Code(info = """
            给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

            如果不存在最后一个单词，请返回 0 。

            说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

             

            示例:

            输入: "Hello World"
            输出: 5

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/length-of-last-word
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int lengthOfLastWord(String s) {
        int len = 0;
        int sLen = s.length();

        int lastLen = len;

        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (len == 0) continue;
                lastLen = len;
                len = 0;
            } else
                len++;
        }

        return len == 0 ? lastLen : len;
    }
}
