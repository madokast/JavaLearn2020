package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0011盛最多水的容器
 * <p>
 * Data
 * 2020/4/5-10:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0011盛最多水的容器 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0011盛最多水的容器.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 8, 6, 2, 5, 4, 8, 3, 7)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                49
        );
    }

    @Code(info = {
            "给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。" +
                    "在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。" +
                    "找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。\n" +
                    "说明：你不能倾斜容器，且 n 的值至少为 2。\n",
            "示例：\n" +
                    "输入：[1,8,6,2,5,4,8,3,7]\n" +
                    "输出：49",
            "执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户内存消耗 :\n" +
                    "40.1 MB, 在所有 Java 提交中击败了42.68%的用户"
    })
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int ih;
        int jh;
        int max = 0;

        int ti, tj;


        while (i < j) {
            LOGGER.info("i,j={},{}",i,j);

            ih = height[i];
            jh = height[j];
            max = Math.max(max, Math.min(ih, jh) * (j - i));

            if (ih > jh) {//j--
                while (i < j && height[j] <= jh)
                    j--;
            } else if (ih < jh) {//i++
                while (i < j && height[i] <= ih)
                    i++;
            } else {
                ti = i;//1 8
                tj = j;//6 8
                while (ti < j && height[j] <= jh)
                    j--;//1
                while (i < tj && height[i] <= ih)
                    i++;//6
                if (tj - j > i - ti) {
                    j = tj;
                } else {
                    i = ti;
                }
            }
        }

        return max;
    }
}
