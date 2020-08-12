package com.zrx.algorithm.leetcode.q0220;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 矩形面积
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0223矩形面积 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0223矩形面积.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

            每个矩形由其左下顶点和右上顶点坐标表示，如图所示。



            示例:

            输入: -3, 0, 3, 4, 0, -1, 9, 2
            输出: 45

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/rectangle-area
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
return -1;
    }
}
