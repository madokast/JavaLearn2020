package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0044通配符匹配
 * <p>
 * Data
 * 2020/5/20-18:17
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0044通配符匹配 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0044通配符匹配.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "aa", "a",
                "aa", "*************",
                "cb", "?a",
                "adceb", "*a*b",
                "acdcb", "a*c?b",
                "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                false, true, false, true, false, false
        );
    }

    @Code(info = """
            给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

            '?' 可以匹配任何单个字符。
            '*' 可以匹配任意字符串（包括空字符串）。
            两个字符串完全匹配才算匹配成功。

            说明:

            s 可能为空，且只包含从 a-z 的小写字母。
            p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
            示例 1:

            输入:
            s = "aa"
            p = "a"
            输出: false
            解释: "a" 无法匹配 "aa" 整个字符串。
            示例 2:

            输入:
            s = "aa"
            p = "*"
            输出: true
            解释: '*' 可以匹配任意字符串。
            示例 3:

            输入:
            s = "cb"
            p = "?a"
            输出: false
            解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
            示例 4:

            输入:
            s = "adceb"
            p = "*a*b"
            输出: true
            解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
            示例 5:

            输入:
            s = "acdcb"
            p = "a*c?b"
            输入: false
            """)
    public boolean isMatch(String s, String p) {
        //            '?' 可以匹配任何单个字符。
        //            '*' 可以匹配任意字符串（包括空字符串）。

//        data = new Boolean[s.length()][p.length()];

        return isMatch(s, 0, simple(p), 0);


    }

//    Boolean[][] data;

    private boolean isMatch(String s, int s0, String p, int p0) {
        //LOGGER.info(List.of(s.substring(s0), p.substring(p0)) + "");

//        if(data[s0][p0]!=null)
//            return data[s0][p0];

        int sLen = s.length();
        int pLen = p.length();

        if (s0 == sLen) {
            // s = ""
            if (p0 == pLen) {
                // p = ""
                return true;
            } else {
                // p = "#.."
                if (p.charAt(p0) == '*')
                    return isMatch(s, s0, p, p0 + 1);
                else
                    return false;
            }
        }

        if (p0 == pLen) {
            // p = ""
            return false;
        }


        switch (p.charAt(p0)) {
            case '?':
                return isMatch(s, s0 + 1, p, p0 + 1);
            case '*':
                return isMatch(s, s0 + 1, p, p0) || isMatch(s, s0, p, p0 + 1);
            default:
                return s.charAt(s0) == p.charAt(p0) && isMatch(s, s0 + 1, p, p0 + 1);
        }
    }

    private String simple(String p) {
        StringBuilder sb = new StringBuilder(p.length());
        char pre = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*' && pre == c)
                continue;

            pre = c;

            sb.append(c);
        }

        return sb.toString();
    }
}
