package com.zrx.algorithm.leetcode.q0020;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * answer = [, , ((())()), ((()))(), (()(())),, (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(),, ]
 * ret = {, , (()(())), , ()((())), ()(()()), ()()(()), ()()()(), (())(()), (())()(), , }
 * <p>
 * Data
 * 2020/4/10-23:43
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0022括号生成 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0022括号生成.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                1, 2, 3, 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        "()"
                ),
                RepeatableSet.of(
                        "()()",
                        "(())"
                ),
                RepeatableSet.of(
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"
                ),
                RepeatableSet.of(
                        "(((())))",
                        "((()()))",
                        "((())())",
                        "((()))()",
                        "(()(()))",
                        "(()()())",
                        "(()())()",
                        "(())(())",
                        "(())()()",
                        "()((()))",
                        "()(()())",
                        "()(())()",
                        "()()(())",
                        "()()()()"
                )
        );
    }

    @Code(info = {
            "数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。\n",
            "示例：\n" +
                    "输入：n = 3\n" +
                    "输出：[\n" +
                    "       \"((()))\",\n" +
                    "       \"(()())\",\n" +
                    "       \"(())()\",\n" +
                    "       \"()(())\",\n" +
                    "       \"()()()\"\n" +
                    "     ]\n"
    })
    public List<String> generateParenthesis(int n) {
        LOGGER.info("深度优先搜索，使用栈");

        // 深度优先搜索
        // 利用函数栈

        // 结果集
        List<String> result = new ArrayList<>();

        if (n == 0)
            return result; // empty

//        generateParenthesis("", n, n, result);
//        return result;

        Stack<Node> stack = new Stack<>();
        stack.push(new Node("", n, n));

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop.finish()) {
                result.add(pop.current);
            } else {
                if (pop.left > 0 && pop.left - 1 <= pop.right) {
                    stack.push(new Node(pop.current + "(", pop.left - 1, pop.right));
                }
                if (pop.right > 0 && pop.left <= pop.right - 1) {
                    stack.push(new Node(pop.current + ")", pop.left, pop.right - 1));
                }
            }
        }

        return result;
    }

    // 改用栈的深度优先搜索
    private class Node {
        String current;
        int left;
        int right;

        public Node(String current, int left, int right) {
            this.current = current;
            this.left = left;
            this.right = right;
        }

        public boolean finish() {
            return left == 0 && right == 0;
        }
    }

    /**
     * 深度优先搜索
     *
     * @param current 当先字符串
     * @param left    左括号剩余数目
     * @param right   右括号剩余数目
     * @param result  结果集合
     */
    private void generateParenthesis(String current, int left, int right, List<String> result) {

        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }

        if (left > right)
            return;

        if (left > 0)
            generateParenthesis(current + '(', left - 1, right, result);

        if (right > 0)
            generateParenthesis(current + ')', left, right - 1, result);
    }


    // 低效算法
    private List<String> generateParenthesis0(int n) {
        if (n == 0)
            return ZERO;
        if (n == 1)
            return ONE;


        HashSet<String> set = new HashSet<>();

        // (----------)
        List<String> sub = generateParenthesis0(n - 1);
        for (String s : sub) {
            set.add('(' + s + ')');
        }

        // (---)(------)
        for (int i = 1; i < n; i++) {
            List<String> leftSub = generateParenthesis0(i);
            List<String> rightSub = generateParenthesis0(n - i);
            for (String left : leftSub) {
                for (String right : rightSub) {
                    set.add(left + right);
                }
            }
        }

        return new ArrayList<>(set);


        // 错误方法
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            // i 最大括号等级
//            StringBuilder base = new StringBuilder(minLevel(n + 1 - i));
//
//            List<String> sub = generateParenthesis(i - 1);
//
//            if(sub.size()==0){
//                list.add(base.toString());
//            }else {
//                for (int j = 1; j < base.length(); j += 2) {
//                    for (String s : sub) {
//                        StringBuilder copy = new StringBuilder(base);
//                        copy.insert(j, s);
//                        list.add(copy.toString());
//                    }
//                }
//            }
//        }
//
//        return list;
    }

    private String maxLevel(int n) {
        if (n == 0)
            return "";
        if (n == 1)
            return "()";

        return "(".repeat(n) + ")".repeat(n);
    }

    private String minLevel(int n) {
        if (n == 0)
            return "";
        if (n == 1)
            return "()";

        return "()".repeat(n);
    }

    private static final List<String> ZERO = List.of();
    private static final List<String> ONE = List.of("()");
}
