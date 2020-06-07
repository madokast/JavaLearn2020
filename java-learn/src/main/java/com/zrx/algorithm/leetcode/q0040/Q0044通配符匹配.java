package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0044通配符匹配
 * <p>
 * 动态规划版
 * <pre>
 *     class Solution {
 *     public boolean isMatch(String s, String p) {
 *         boolean[][] value = new boolean[p.length()+1][s.length()+1];
 *         value[0][0] = true;
 *         for(int i = 1;i <= s.length();i++){
 *             value[0][i] = false;
 *         }
 *         for(int i = 1;i <= p.length(); i++){
 *             if(p.charAt(i-1) == '*'){
 *                 value[i][0] = value[i-1][0];
 *                 for(int j = 1;j <= s.length(); j++){
 *                     value[i][j] = (value[i][j-1] || value[i-1][j]);
 *                 }
 *             }else if(p.charAt(i-1) == '?'){
 *                 value[i][0] = false;
 *                 for(int j = 1;j <= s.length(); j++){
 *                     value[i][j] = value[i-1][j-1];
 *                 }
 *             }else {
 *                 value[i][0] = false;
 *                 for(int j = 1;j <= s.length(); j++){
 *                     value[i][j] = s.charAt(j-1) == p.charAt(i-1) && value[i-1][j-1];
 *                 }
 *             }
 *
 *         }
 *         return value[p.length()][s.length()];
 *
 *     }
 * }
 * </pre>
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
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb",
                "a", "a*"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                false, true, false, true, false, false, true
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

        // 递归法 超时
//        return isMatch(s, 0, simple(p), 0);

        // 动态规划法
//        return isMatchDP(s, p);

        // 快速动态规划
        return isMatchDpQuick(s, p);
    }

    // 动态规划法
    public boolean isMatchDP(String s, String p) {
        p = simple(p);

        int pLen = p.length();
        int sLen = s.length();

        // [i][j]
        // 表示 p[0~i] 匹配 s[0~j] 的情况
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];

        // 空串 当然能匹配空串
        dp[0][0] = true;

        // 但是 p="" 无法匹配任何非空串
        // [o][i]==false
        // 这一步可以省去，因为 Java boolean 自动为 false
//        for (int i = 1; i <= sLen; i++) {
//            dp[0][i] = false;
//        }

        // 然后 利用p[0~(i-1)] 匹配 s 的结果
        // 求 p[o-i] 匹配 s
        for (int i = 1; i <= pLen; i++) {
            // p 中第 i 个字母，即 p.charAt(i-1)
            char pc = p.charAt(i - 1);

            switch (pc) {
                case '?':
                    // '?'一定是要匹配一个字符的
                    // 所以 无法匹配空串
                    // 可以省略
//                    dp[i][0] = false;

                    System.arraycopy(dp[i - 1], 0, dp[i], 1, sLen);

                    break;
                case '*':
                    // 星号可以匹配任何东西，也可以不匹配

                    // 这里不放入循环，仅仅是 j-1 可能越界
                    dp[i][0] = dp[i - 1][0];
                    for (int j = 1; j <= sLen; j++) {
                        dp[i][j] =
//                                dp[i - 1][j - 1] || // * 匹配一个字母  包含在第三个[匹配多个]中了
                                dp[i - 1][j] || // * 跳过
                                        dp[i][j - 1]; // 匹配多个
                    }
                    break;
                default:
                    // 其他情况，即完全匹配一个字符
                    // 无法匹配 s 是空串的情况
                    // 可以省略
//                    dp[i][0] = false;

                    for (int j = 1; j <= sLen; j++) {
                        // 下面匹配以 sc 结尾的 s串和以 pc 结尾的 p串
                        char sc = s.charAt(j - 1);

                        // pc 不等于 sc 一定无法匹配成功
                        dp[i][j] = pc == sc && dp[i - 1][j - 1];
                    }
            }

            // 快速退出
            boolean quickFail = true;
            for (boolean b : dp[i]) {
                if (b) {
                    quickFail = false;
                    break;
                }
            }

            if (quickFail)
                return false;
        }

//        if (dp.length < 6)
            LOGGER.info("dp = {}", ToString.arrayToFormatString(dp[pLen]));

        return dp[pLen][sLen];
    }

    // 动态规划法，只开一行数组
    public boolean isMatchDpQuick(String s, String p) {
        //p = simple(p);

        int pLen = p.length();
        int sLen = s.length();

        // [i][j]
        // 表示 p[0~i] 匹配 s[0~j] 的情况
//        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        boolean[] dp = new boolean[sLen + 1];

        // 空串 当然能匹配空串
        dp[0] = true;

        // 但是 p="" 无法匹配任何非空串
        // [o][i]==false
        // 这一步可以省去，因为 Java boolean 自动为 false
//        for (int i = 1; i <= sLen; i++) {
//            dp[0][i] = false;
//        }

        // 然后 利用p[0~(i-1)] 匹配 s 的结果
        // 求 p[o-i] 匹配 s
        for (int i = 1; i <= pLen; i++) {
            // p 中第 i 个字母，即 p.charAt(i-1)
            char pc = p.charAt(i - 1);

            switch (pc) {
                case '?':
                    // '?'一定是要匹配一个字符的
                    // 所以 无法匹配空串

                    System.arraycopy(dp, 0, dp, 1, sLen);

                    dp[0] = false;

                    break;
                case '*':
                    // 星号可以匹配任何东西，也可以不匹配

                    // 这里不放入循环，仅仅是 j-1 可能越界
//                    dp[i][0] = dp[i - 1][0];

                    for (int j = 1; j <= sLen; j++) {
                        dp[j] |= dp[j - 1];
                    }

//                    for (int j = 1; j <= sLen; j++) {
//                        dp[i][j] =
////                                dp[i - 1][j - 1] || // * 匹配一个字母  包含在第三个[匹配多个]中了
//                                dp[i - 1][j] || // * 跳过
//                                        dp[i][j - 1]; // 匹配多个
//                    }
                    break;
                default:
                    // 其他情况，即完全匹配一个字符
                    // 无法匹配 s 是空串的情况
                    // 可以省略

                    for (int j = sLen; j > 0; j--) {
                        // 下面匹配以 sc 结尾的 s串和以 pc 结尾的 p串
                        char sc = s.charAt(j - 1);

                        // pc 不等于 sc 一定无法匹配成功
                        dp[j] = pc == sc && dp[j - 1];
                    }

                    dp[0] = false;
            }

            // 快速退出
            boolean quickFail = true;
            for (boolean b : dp) {
                if (b) {
                    quickFail = false;
                    break;
                }
            }

            if (quickFail)
                return false;
        }


        //LOGGER.info("dp = {}", ToString.arrayToFormatString(dp));

        return dp[sLen];
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
