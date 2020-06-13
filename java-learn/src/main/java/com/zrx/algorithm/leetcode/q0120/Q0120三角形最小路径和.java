package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 三角形最小路径和
 * <p>
 * Data
 * 2020/6/13-19:12
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0120三角形最小路径和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0120三角形最小路径和.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

            相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

             

            例如，给定三角形：

            [
                 [2],
                [3,4],
               [6,5,7],
              [4,1,8,3]
            ]
            自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

             

            说明：

            如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/triangle
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int minimumTotal(List<List<Integer>> triangle) {
        return 0;
    }
}
