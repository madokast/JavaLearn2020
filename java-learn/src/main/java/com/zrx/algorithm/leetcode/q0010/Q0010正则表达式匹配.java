package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 正则表达式匹配
 * <p>
 * Data
 * 2020/3/31-21:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0010正则表达式匹配 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0010正则表达式匹配.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "aa", "a",
                "aa", "a*",
                "aa", ".*",
                "aab", "c*a*b",
                "mississippi", "mis*is*p*.",
                "aaa", "a.a",
                "a", "ab*",
                "bbbba", ".*a*a",
                "a", "a*a",
                "ab", ".*..",
                "aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                false, true, true, true, false, true, true, true, true, true, false
        );
    }

    @Code(info = {
            "给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。\n" +
                    "'.' 匹配任意单个字符\n" +
                    "'*' 匹配零个或多个前面的那一个元素\n" +
                    "所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。\n" +
                    "说明:\n" +
                    "s 可能为空，且只包含从 a-z 的小写字母。\n" +
                    "p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。\n" +
                    "示例 1:\n" +
                    "输入:\n" +
                    "s = \"aa\"\n" +
                    "p = \"a\"\n" +
                    "输出: false\n" +
                    "解释: \"a\" 无法匹配 \"aa\" 整个字符串。\n" +
                    "示例 2:\n" +
                    "输入:\n" +
                    "s = \"aa\"\n" +
                    "p = \"a*\"\n" +
                    "输出: true\n" +
                    "解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 \"aa\" 可被视为 'a' 重复了一次。\n" +
                    "示例 3:\n" +
                    "输入:\n" +
                    "s = \"ab\"\n" +
                    "p = \".*\"\n" +
                    "输出: true\n" +
                    "解释: \".*\" 表示可匹配零个或多个（'*'）任意字符（'.'）。\n" +
                    "示例 4:\n" +
                    "输入:\n" +
                    "s = \"aab\"\n" +
                    "p = \"c*a*b\"\n" +
                    "输出: true\n" +
                    "解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 \"aab\"。\n" +
                    "示例 5:\n" +
                    "输入:\n" +
                    "s = \"mississippi\"\n" +
                    "p = \"mis*is*p*.\"\n" +
                    "输出: false\n",
            "一个一个读，p 模板串有三种情况，1.单个字母a，2.单个点，3.字母加*，4，点*",
            "终于做出来了",
            "执行用时 :21 ms, 在所有 Java 提交中击败了46.28%的用户\n" +
                    "内存消耗 :40 MB, 在所有 Java 提交中击败了23.61%的用户",
            "2020年4月5日10点44分 优化成功",
            "执行用时 :3 ms, 在所有 Java 提交中击败了91.40%的用户"
    })

    public boolean isMatch(String s, String p) {
        return isMatch0(s, 0, simplifyPattern(p), 0);
    }

    public boolean isMatch0(String s, int i, String p, int j) {
        // s string
        // p pattern


        if (p.length() <= j)
            return s.length() <= i;
        if (s.length() <= i)
            return ismMatchEmpty(p, j);


        do {
            char sc = s.charAt(i);
            char pc = p.charAt(j);

            char pc2 = j >= p.length() - 1 ? NULL_CHAR : p.charAt(j + 1);

            if (isAlphabet(pc) && pc2 != ASTERISK) {
                //LOGGER.info("单个字母");
                //1.单个字母a
                if (sc != pc)
                    return false;
                i++;
                j++;
            } else if (pc == DOT && pc2 != ASTERISK) {
                //LOGGER.info("单个点");
                //2.单个点
                i++;
                j++;
            } else if (isAlphabet(pc) && pc2 == ASTERISK) {
                //LOGGER.info("字母加*");
                //字母加*
                if (pc == sc) {
                    return (isMatch0(s, i + 1, p, j)) ||
                            //(j + 2 < p.length() && isMatch0(s, i + 1, p, j + 2)) ||
                            (j + 2 < p.length() && isMatch0(s, i, p, j + 2));
                } else {
                    return j + 2 < p.length() && isMatch0(s, (i), p, (j + 2));
                }
            } else if (pc == DOT) {
                //LOGGER.info("点*");
                //点*
                return (isMatch0(s, i + 1, p, j)) ||
                        //(j + 2 < p.length() && isMatch0(s, (i + 1), p, (j + 2))) ||
                        (j + 2 < p.length() && isMatch0(s, (i), p, (j + 2)));
            }

        } while (i != s.length() && j != p.length());

        return (i == s.length() && j == p.length()) ||
                (i == s.length() && ismMatchEmpty(p, (j)));

    }

    private String simplifyPattern(String p) {

        String ret = null;

        for (int i = 1; i < p.length() - 2; i++) {
            if (p.charAt(i) == ASTERISK) {
                if (p.charAt(i - 1) == p.charAt(i + 1) && p.charAt(i + 2) == ASTERISK) {
                    ret = p.substring(0, i + 1) + p.substring(i + 3);
                }
            }
        }

        if (ret == null)
            return p;
        else
            return simplifyPattern(ret);
    }

    private boolean ismMatchEmpty(String p, int i) {
        //LOGGER.info("ismMatchEmpty p={}", p);
        if ((p.length() - i) % 2 == 1)
            return false;

        i++;
        for (; i < p.length(); i += 2) {
            if (p.charAt(i) != ASTERISK)
                return false;
        }

        return true;
    }

    private boolean isAlphabet(char c) {
        return c >= 'a' && c <= 'z';
    }

    private final char NULL_CHAR = '\0';
    private final char DOT = '.';
    private final char ASTERISK = '*';
}
