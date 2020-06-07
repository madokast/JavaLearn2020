package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 最小覆盖子串
 * <p>
 * Data
 * 2020/5/31-13:45
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0076最小覆盖子串 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0076最小覆盖子串.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "ADOBECODEBANC", "ABC",
                "aab", "aab",
                "bba", "ab",
                "cabwefgewcwaefgcf", "cae"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("BANC", "aab", "ba", "cwae");
    }

    @Code(info = """
            给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

            示例：

            输入: S = "ADOBECODEBANC", T = "ABC"
            输出: "BANC"
            说明：

            如果 S 中不存这样的子串，则返回空字符串 ""。
            如果 S 中存在这样的子串，我们保证它是唯一的答案。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/minimum-window-substring
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String minWindow(String s, String t) {
        final int sl = s.length();
        if (sl == 0) return "";

        final int tl = t.length();

        final Map<Character, LinkedList<Integer>> tMap = new HashMap<>();

        // 解构 t 串
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            LinkedList<Integer> list = tMap.getOrDefault(c, new LinkedList<>());
            list.addLast(i);
            tMap.put(c, list);
        }

        Map<Character, LinkedList<Integer>> sMap = new HashMap<>();
        Deque<Integer> sList = new LinkedList<>();

        int i = 0;
        int sMapLen = 0;
        int left = -1;
        int right = -1;
        OUTER:
        for (; i < sl; i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                LinkedList<Integer> scList = sMap.getOrDefault(c, new LinkedList<>());
                scList.addLast(i);
                sMap.put(c, scList);
                sMapLen++;

                sList.addLast(i);

                if (left == -1)
                    left = i;

                if (sMapLen >= tl) {
                    // 判断是不是找到第一个解
                    //LOGGER.info("判断是不是找到第一个解");
                    for (Character tc : tMap.keySet()) {
                        LinkedList<Integer> tList = tMap.get(tc);
                        LinkedList<Integer> stcList = sMap.get(tc);
//                        LOGGER.info("stcList = {}", stcList);
//                        LOGGER.info("tList = {}", tList);
                        if (stcList == null || stcList.size() < tList.size()) {
                            continue OUTER;
                        }
//                        LOGGER.info("END--");
                    }
                    // 循环能完成，那就说明找到了
                    right = i + 1;
                    break;
                }
            }
        }

//        LOGGER.info("tMap = {}", tMap);
//        LOGGER.info("sMap = {}", sMap);
//        LOGGER.info("sMapLen = {}", sMapLen);
//        LOGGER.info("i = {}", i);
//        LOGGER.info("sl = {}", sl);
//        LOGGER.info("right = {}", right);

        if (i == sl || right == -1)
            return "";


        // 查看是不是可以缩小 ans
        Integer first = sList.getFirst();
        char scFisrt = s.charAt(first);
        LinkedList<Integer> list = sMap.get(scFisrt);
        LinkedList<Integer> tList = tMap.get(scFisrt);
        while (tList.size() < list.size()) {
            list.removeFirst();
            sList.removeFirst();

            first = sList.getFirst();
            scFisrt = s.charAt(first);
            list = sMap.get(scFisrt);
            tList = tMap.get(scFisrt);
        }


        String ans = s.substring(sList.getFirst(), sList.getLast() + 1);
        LOGGER.info("ans = {}", ans);

        i++;

        for (; i < sl; i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                LinkedList<Integer> scList = sMap.get(c);
                scList.addLast(i);
                sMap.put(c, scList);

                sList.addLast(i);

                // 查看是不是可以缩小 ans
                first = sList.getFirst();
                Integer last = sList.getLast();
                scFisrt = s.charAt(first);
                char scLast = s.charAt(last);
                if (scFisrt == scLast) {
                    // 去除 first
                    list = sMap.get(scFisrt);
                    list.removeFirst();

                    sList.removeFirst();

                    // 继续搜索
                    first = sList.getFirst();
                    scFisrt = s.charAt(first);
                    list = sMap.get(scFisrt);
                    tList = tMap.get(scFisrt);
                    while (tList.size() < list.size()) {
                        list.removeFirst();
                        sList.removeFirst();

                        first = sList.getFirst();
                        scFisrt = s.charAt(first);
                        list = sMap.get(scFisrt);
                        tList = tMap.get(scFisrt);
                    }

                    // 搜索完毕，更新答案
                    int ri = sList.getLast() + 1;
                    int le = sList.getFirst();
                    if ((ri - le) < ans.length()) {
                        ans = s.substring(le, ri);
                        LOGGER.info("ans = {}", ans);
                    }
                }

            }
        }

        return ans;
    }
}
