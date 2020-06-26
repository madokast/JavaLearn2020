package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 直线上最多的点数
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0149直线上最多的点数 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0149直线上最多的点数.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

            示例 1:

            输入: [[1,1],[2,2],[3,3]]
            输出: 3
            解释:
            ^
            |
            |        o
            |     o
            |  o  
            +------------->
            0  1  2  3  4
            示例 2:

            输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
            输出: 4
            解释:
            ^
            |
            |  o
            |     o        o
            |        o
            |  o        o
            +------------------->
            0  1  2  3  4  5  6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/max-points-on-a-line
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int maxPoints(int[][] points) {
        return -1;
    }
}
