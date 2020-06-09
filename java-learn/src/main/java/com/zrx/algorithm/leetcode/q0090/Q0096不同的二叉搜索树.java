package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同的二叉搜索树
 * <p>
 * Data
 * 2020/6/6-16:34
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0096不同的二叉搜索树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0096不同的二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                5
        );
    }

    @Code(info = """
            给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

            示例:

            输入: 3
            输出: 5
            解释:
            给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

               1         3     3      2      1
                \\       /     /      / \\      \\
                 3     2     1      1   3      2
                /     /       \\                 \\
               2     1         2                 3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/unique-binary-search-trees
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numTrees(int n) {
        // 动态规划
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // dp[2] ?
            int num = 0;
            for (int j = 0; j < i; j++) {
                int l = dp[j];
                int r = dp[i - j - 1];
                num += (l == 0 || r == 0) ? Math.max(l, r) : l * r;
            }
            dp[i] = num;
        }

        return dp[n];
    }

    public int numTrees递归(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            int num = 0;
            for (int i = 0; i < n; i++) {
                int r = numTrees递归(i);
                if (r == 0) r = 1;
                int l = numTrees递归(n - i - 1);
                if (l == 0) l = 1;

                num += r * l;
            }

            return num;
        }
    }
}
