package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 分割回文串
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0131分割回文串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0131分割回文串.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "aab"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of("aa", "b"),
                        List.of("a", "a", "b")
                )
        );
    }

    @Code(info = """
            给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

            返回 s 所有可能的分割方案。

            示例:

            输入: "aab"
            输出:
            [
              ["aa","b"],
              ["a","a","b"]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/palindrome-partitioning
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        dfs(s, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(String s, int start, Deque<String> stack, List<List<String>> ans) {
        int length = s.length();
        if (start == length) {
            ans.add(new ArrayList<>(stack));
        } else {
            for (int i = start + 1; i <= length; i++) {
                if (isPalindrome(s, start, i)) {
                    stack.addLast(s.substring(start, i));
                    dfs(s, i, stack, ans);
                    stack.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String s, int startIn, int endEx) {
        int mid = (startIn + endEx) / 2;
        for (int i = startIn; i < mid; i++) {
            if (s.charAt(i) != s.charAt(endEx - 1 - i + startIn))
                return false;
        }
        return true;
    }


}
