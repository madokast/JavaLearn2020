package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 最短回文串
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0214最短回文串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0214最短回文串.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, "aacecaaa", "abcd"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "aaacecaaa", "dcbabcd"
        );
    }

    @Code(info = """
            给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

            示例 1:

            输入: "aacecaaa"
            输出: "aaacecaaa"
            示例 2:

            输入: "abcd"
            输出: "dcbabcd"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/shortest-palindrome
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] chars = s.toCharArray();

        int length = chars.length;
        int min = length - 1;

        for (int i = length / 2; i >= 0; i--) {
            if (paInFirst(chars, i)) {
                min = length - 2 * i - 1;
                break;
            }
            if (paInFirstGap(chars, i)) {
                min = length - 2 * i;
                break;
            }

        }

        StringBuilder sb = new StringBuilder(length + min);
        for (int i = 0; i < min; i++) {
            sb.append(chars[length - 1 - i]);
        }

        sb.append(s);

        //          aacecaaa
        //answer = aaacecaaa
        //ret =  aaaaacecaaa

        return sb.toString();
    }

    private boolean paInFirst(char[] word, int center) {
        int left = center - 1;
        int right = center + 1;
        int length = word.length;
        while (left >= 0 && right < length && word[left] == word[right]) {
            left--;
            right++;
        }

        return left == -1;
    }

    private boolean paInFirstGap(char[] word, int center) {
        int left = center - 1;
        int right = center;
        int length = word.length;
        while (left >= 0 && right < length && word[left] == word[right]) {
            left--;
            right++;
        }

        return left == -1;
    }
}
