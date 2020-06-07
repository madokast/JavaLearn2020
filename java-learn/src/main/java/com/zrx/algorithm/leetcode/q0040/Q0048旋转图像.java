package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0048旋转图像
 * <p>
 * Data
 * 2020/5/24-20:07
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0048旋转图像 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0048旋转图像.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                new int[][]{{1}},
                ArrayFactory.create(
                        ArrayFactory.create(1, 2),
                        ArrayFactory.create(3, 4)
                ),
                ArrayFactory.create(
                        ArrayFactory.create(1, 2, 3),
                        ArrayFactory.create(4, 5, 6),
                        ArrayFactory.create(7, 8, 9)
                ), ArrayFactory.create(
                        ArrayFactory.create(5, 1, 9, 11),
                        ArrayFactory.create(2, 4, 8, 10),
                        ArrayFactory.create(13, 3, 6, 7),
                        ArrayFactory.create(15, 14, 12, 16)
                ),
                //[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
                ArrayFactory.create(
                        ArrayFactory.create(5, 1, 9, 11),
                        ArrayFactory.create(2, 4, 8, 10),
                        ArrayFactory.create(13, 3, 6, 7),
                        ArrayFactory.create(15, 14, 12, 16)
                )
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                new int[][]{{1}},
                ArrayFactory.create(
                        ArrayFactory.create(3, 1),
                        ArrayFactory.create(4, 2)
                ),
                ArrayFactory.create(
                        ArrayFactory.create(7, 4, 1),
                        ArrayFactory.create(8, 5, 2),
                        ArrayFactory.create(9, 6, 3)
                ), ArrayFactory.create(
                        ArrayFactory.create(15, 13, 2, 5),
                        ArrayFactory.create(14, 3, 4, 1),
                        ArrayFactory.create(12, 6, 8, 9),
                        ArrayFactory.create(16, 7, 10, 11)
                ),
                //[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
                //[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
                ArrayFactory.create(
                        ArrayFactory.create(15, 13, 2, 5),
                        ArrayFactory.create(14, 3, 4, 1),
                        ArrayFactory.create(12, 6, 8, 9),
                        ArrayFactory.create(16, 7, 10, 11)
                )
        );
    }

    @Code(info = """
            给定一个 n × n 的二维矩阵表示一个图像。

            将图像顺时针旋转 90 度。

            说明：

            你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

            示例 1:

            给定 matrix =
            [
              [1,2,3],
              [4,5,6],
              [7,8,9]
            ],

            原地旋转输入矩阵，使其变为:
            [
              [7,4,1],
              [8,5,2],
              [9,6,3]
            ]
            示例 2:

            给定 matrix =
            [
              [ 5, 1, 9,11],
              [ 2, 4, 8,10],
              [13, 3, 6, 7],
              [15,14,12,16]
            ],

            原地旋转输入矩阵，使其变为:
            [
              [15,13, 2, 5],
              [14, 3, 4, 1],
              [12, 6, 8, 9],
              [16, 7,10,11]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/rotate-image
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[][] rotate(int[][] matrix) {
        int d = matrix.length;
        int axis = d / 2;


        for (int j = 0; j <= axis; j++) {
            for (int i = j; i < d - j - 1; i++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[d-1-j][i];
                matrix[d-1-j][i] = matrix[d-1-i][d-1-j];
                matrix[d-1-i][d-1-j] = matrix[j][d-1-i];
                matrix[j][d-1-i] = t;
            }
        }

        return matrix;
    }

    public void rotateQuad(int[][] m, int[] v) {
        int d = m.length;

        int i = v[0];
        int j = v[1];

//        int a1 = m[i][j];
//        int a2 = m[j][d-1-i];
//        int a3 = m[d-1-i][d-1-j];
//        int a4 = m[d-1-j][i];

        int t = m[i][j];
        m[i][j] = m[d-1-j][i];
        m[d-1-j][i] = m[d-1-i][d-1-j];
        m[d-1-i][d-1-j] = m[j][d-1-i];
        m[j][d-1-i] = t;


        // 下面作废

//        int prev;
//        int cur = get(m, v);

        /**
         * rotateIndex(v, d)
         * vi vj d
         *         double[] dv = new double[]{v[0], v[1]};
         *
         *         convert(dv, d);
         * i j d
         *         -- double x = v[0]; // i
         *         -- double y = v[1]; // j
         *         -- double axis = (d - 1) / 2.0; // axis = (d-1)/2
         *
         *         -- v[0] = -axis + y; // i2 = -(d-1)/2 + j
         *         -- v[1] = axis - x; // j2 = (d-1)/2 - i
         *
         *
         *         rotateCenterCoo(dv); // dv = -(d-1)/2 + j , (d-1)/2 - i
         *         -- double x = v[0]; // x = -(d-1)/2 + j
         *         -- double y = v[1]; // y = (d-1)/2 - i
         *
         *         -- v[0] = y; // v0 = (d-1)/2 - i
         *         -- v[1] = -x; // v1 = (d-1)/2 - j
         *
         *
         *
         *         convertBack(dv, d); // dv = (d-1)/2 - i , (d-1)/2 - j
         *
         *         -- double x = v[0]; //  x = (d-1)/2 - i
         *         -- double y = v[1]; // y = (d-1)/2 - j
         *         -- double axis = (d - 1) / 2.; // axis = (d-1)/2
         *
         *         -- v[0] = axis - y; // (d-1)/2 - ((d-1)/2 - j) = j
         *         -- v[1] = axis + x; // (d-1)/2 + (d-1)/2 - i = d-1-i
         *
         *
         *
         *         v[0] = (int) Math.round(dv[0]);
         *         v[1] = (int) Math.round(dv[1]);
         *
         *
         */
//        rotateIndex(v, d);
//
//
//        prev = get(m, v);
//        set(m, v, cur);// 1
//        cur = prev;
//
//        rotateIndex(v, d);
//        prev = get(m, v);
//        set(m, v, cur);// 2
//        cur = prev;
//
//        rotateIndex(v, d);
//        prev = get(m, v);
//        set(m, v, cur);//3
//        cur = prev;
//
//        rotateIndex(v, d);
//        prev = get(m, v);
//        set(m, v, cur);// 4
    }

    /**
     * 旋转 90° 后的坐标
     *
     * @param v 坐标 (i,j)
     * @param d 维度
     */
    private void rotateIndex(int[] v, int d) {
//        //LOGGER.info("v0 = {}", v);
//
//        double[] dv = new double[]{v[0], v[1]};
//
//        convert(dv, d);
//
//        //LOGGER.info("v-c = {}", dv);
//
//        rotateCenterCoo(dv);
//
//        //LOGGER.info("v-r = {}", dv);
//
//        convertBack(dv, d);
//
//        v[0] = (int) Math.round(dv[0]);
//        v[1] = (int) Math.round(dv[1]);
//
//        //LOGGER.info("v-b = {}", v);

        int i = v[0];
        int j = v[1];

        v[0] = j;
        v[1] = d-1-i;
    }

    // 直角坐标系旋转
    private void rotateCenterCoo(double[] v) {
        double x = v[0];
        double y = v[1];

        v[0] = y;
        v[1] = -x;
    }

    private void convert(double[] v, int d) {
        double x = v[0];
        double y = v[1];
        double axis = (d - 1) / 2.0;

        v[0] = -axis + y;
        v[1] = axis - x;

    }

    private void convertBack(double[] v, int d) {
        double x = v[0];
        double y = v[1];
        double axis = (d - 1) / 2.;

        v[0] = axis - y;
        v[1] = axis + x;
    }

    private int get(int[][] m, int[] v) {
        return m[v[0]][v[1]];
    }

    private void set(int[][] m, int[] v, int val) {
        m[v[0]][v[1]] = val;
    }


    private void swap2(int[][] arr, int i, int j, int i0, int j0) {
        arr[i][j] = arr[i][j] ^ arr[i0][j0];
        arr[i0][j0] = arr[i][j] ^ arr[i0][j0];
        arr[i][j] = arr[i][j] ^ arr[i0][j0];
    }
}
