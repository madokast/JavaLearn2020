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
        //-2
        //-2
        //2
        //2
        //-1
        //-1
        //1
        //1

        //0
        //0
        //0
        //0
        //-1
        //-1
        //1
        //1

        //-2
        //-2
        //2
        //2
        //-4
        //3
        //-3
        //4

        //-2
        //-2
        //2
        //2
        //-3
        //1
        //-1
        //3   19
        return InputFactory.create(
                8,
                -3, 0, 3, 4, 0, -1, 9, 2,
                -2, -2, 2, 2, -1, -1, 1, 1,
                0, 0, 0, 0, -1, -1, 1, 1,
                -2, -2, 2, 2, -4, 3, -3, 4,
                -2, -2, 2, 2, -3, 1, -1, 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                45, 16, 4, 17, 19
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
        int caseEF, caseGH;

        int width1 = C - A;
        int height1 = D - B;
        int area1 = width1 * height1;

        int width2 = G - E;
        int height2 = H - F;
        int area2 = width2 * height2;

        if (area1 == 0) return area2;
        if (area2 == 0) return area1;

        if (E <= A) { // 147
            if (F >= D) { //1
                return area1 + area2;
            } else if (F >= B) { //4
                caseEF = 4;
            } else { // 7
                caseEF = 7;
            }
        } else if (E <= C) { // 258
            if (F >= D) { //2
                return area1 + area2;
            } else if (F >= B) { //5
                caseEF = 5;
            } else { // 8
                caseEF = 8;
            }
        } else { // 369
            return area1 + area2;
        }


        if (G <= A) { // 147
            if (H >= D) { //1
                caseGH = 1;
            } else if (H >= B) { //4
                caseGH = 4;
            } else { // 7
                caseGH = 7;
            }
        } else if (G <= C) { // 258
            if (H >= D) { //2
                caseGH = 2;
            } else if (H >= B) { //5
                caseGH = 5;
            } else { // 8
                caseGH = 8;
            }
        } else { // 369
            if (H >= D) { //3
                caseGH = 3;
            } else if (H >= B) { //6
                caseGH = 6;
            } else { // 9
                caseGH = 9;
            }
        }

        LOGGER.info("caseEF = {}", caseEF);
        LOGGER.info("caseGH = {}", caseGH);

        int width, height;

        switch (caseEF) {
            case 4:
                switch (caseGH) {
                    case 1:
                        return area1 + area2;
                    case 2:
                        width = G - A;
                        height = D - F;
                        return area1 + area2 - width * height;
                    case 3:
                        width = width1;
                        height = D - F;
                        return area1 + area2 - width * height;
                    case 4:
                        return area1 + area2;
                    case 5:
                        width = G - A;
                        height = height2;
                        return area1 + area2 - width * height;
                    case 6:
                        width = width1;
                        height = height2;
                        return area1 + area2 - width * height;
                    case 7:
                    case 8:
                    case 9:
                        throw new RuntimeException();

                }
            case 5:
                switch (caseGH) {
                    case 1:
                    case 4:
                    case 7:
                    case 8:
                    case 9:
                        throw new RuntimeException();
                    case 2:
                        width = width2;
                        height = D - F;
                        return area1 + area2 - width * height;
                    case 5:
                        return area1;
                    case 3:
                        width = C - E;
                        height = D - F;
                        return area1 + area2 - width * height;
                    case 6:
                        width = C - E;
                        height = height2;
                        return area1 + area2 - width * height;
                }
            case 7:
                switch (caseGH) {
                    case 1:
                    case 4:
                    case 7:
                    case 8:
                    case 9:
                        return area1 + area2;
                    case 2:
                        width = G - A;
                        height = height1;
                        return area1 + area2 - width * height;
                    case 5:
                        width = G - A;
                        height = H - B;
                        return area1 + area2 - width * height;
                    case 3:
                        return area2;
                    case 6:
                        width = width1;
                        height = H - B;
                        return area1 + area2 - width * height;
                }
            case 8:
                switch (caseGH) {
                    case 1:
                    case 4:
                    case 7:
                        throw new RuntimeException();
                    case 8:
                    case 9:
                        return area1 + area2;
                    case 2:
                        width = width2;
                        height = height1;
                        return area1 + area2 - width * height;
                    case 5:
                        width = width2;
                        height = H - B;
                        return area1 + area2 - width * height;
                    case 3:
                        width = C - E;
                        height = height1;
                        return area1 + area2 - width * height;
                    case 6:
                        width = C - E;
                        height = H - B;
                        return area1 + area2 - width * height;
                }
        }

        throw new RuntimeException();
    }
}
