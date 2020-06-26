package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 分发糖果
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0135分发糖果 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0135分发糖果.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                ArrayFactory.create(1, 0, 2),
                ArrayFactory.create(1, 3, 2),
                ArrayFactory.create(1, 3, 4, 5, 2)

        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                5, 4, 11
        );
    }

    @Code(info = """
            老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

            你需要按照以下要求，帮助老师给这些孩子分发糖果：

            每个孩子至少分配到 1 个糖果。
            相邻的孩子中，评分高的孩子必须获得更多的糖果。
            那么这样下来，老师至少需要准备多少颗糖果呢？

            示例 1:

            输入: [1,0,2]
            输出: 5
            解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
            示例 2:

            输入: [1,2,2]
            输出: 4
            解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
                 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/candy
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            int cur = ratings[i];
            int next = ratings[i + 1];
            if (next > cur) candies[i + 1] = candies[i] + 1;
        }

        LOGGER.info("candies = {}", candies);

        for (int i = ratings.length - 1; i >= 1; i--) {
            int cur = ratings[i];
            int pre = ratings[i - 1];
            if (pre > cur && candies[i - 1] <= candies[i]) candies[i - 1] = candies[i] + 1;
        }

        LOGGER.info("candies = {}", candies);

        return Arrays.stream(candies).sum();
    }
}
