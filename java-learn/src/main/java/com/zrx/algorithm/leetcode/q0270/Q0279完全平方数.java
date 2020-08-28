package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description
 * 完全平方数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0279完全平方数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0279完全平方数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, 12, 13
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                3, 2
        );
    }

    @Code(info = """
            给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

            示例 1:

            输入: n = 12
            输出: 3\040
            解释: 12 = 4 + 4 + 4.
            示例 2:

            输入: n = 13
            输出: 2
            解释: 13 = 4 + 9.

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/perfect-squares
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        int[] ss = new int[sqrt];
        for (int i = 0; i < ss.length; i++) {
            ss[i] = (i + 1) * (i + 1);
        }

        Set<Integer> layer = new HashSet<>();
        layer.add(n);
        int depth = 1;

        while (true) {
            if(depth==4) return 4;

            Set<Integer> nextLayer = new HashSet<>();

            for (Integer num : layer) {
                for (int s : ss) {
                    int diff = num - s;
                    if (diff > 0) nextLayer.add(diff);
                    else if (diff < 0) break;
                    else return depth;
                }
            }

            layer = nextLayer;
            depth++;
        }
    }


    public int numSquares垃圾(int n) {
        if (n == 0) return 0;

        int num = Integer.MAX_VALUE;

        int sqrt = (int) Math.sqrt(n);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        for (int i = sqrt; i > 0; i--) {
            int t = i * i;
            if (n / t > num) break;
            if (dp[n - t] == -1) {
                dp[n - t] = numSquares(n - t);
            }


            num = Math.min(num, dp[n - t]);
        }

        return num + 1;
    }

//    private int numSquares(int n) {
//        if (n == 0) return 0;
//
//        int num = Integer.MAX_VALUE;
//
//        for (int i = (int) Math.sqrt(n)); i > 0; i--) {
//            int t = i * i;
//            if (n / t > num) break;
//            num = Math.min(num, numSquares(n - t, i));
//        }
//
//        return num + 1;
//    }

//    private int numSquares(int n, int k) {
//        if (n == 0) return 0;
//
//        int num = Integer.MAX_VALUE;
//
//        for (int i = Math.min(k, (int) Math.sqrt(n)); i > 0; i--) {
//            int t = i * i;
//            if (n / t > num) break;
//            num = Math.min(num, numSquares(n - t, i));
//        }
//
//        return num + 1;
//    }
}
