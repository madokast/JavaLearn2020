package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0028实现strStr
 * <p>
 * Data
 * 2020/5/11-15:32
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0028实现strStr implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0028实现strStr.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "hello", "ll",
                "aaaaa", "bba"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, -1);
    }

    @Code(info = """
            实现 strStr() 函数。

            给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

            示例 1:

            输入: haystack = "hello", needle = "ll"
            输出: 2
            示例 2:

            输入: haystack = "aaaaa", needle = "bba"
            输出: -1
            说明:

            当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

            对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/implement-strstr
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        int lenH = haystack.length(); //5
        int lenN = needle.length(); //2

        if (lenN > lenH)
            return -1;

        for (int i = 0; i < (lenH - lenN + 1); i++) {//4
            int j, k;
            for (j = 0, k = i; j < lenN; j++, k++) {
                LOGGER.info("" + i + j + k);
                if (!(haystack.charAt(k) == needle.charAt(j)))
                    break;
            }

            if (j == lenN)
                return i;
        }

        return -1;
    }
}
