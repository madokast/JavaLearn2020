package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 颠倒二进制位
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0190颠倒二进制位 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0190颠倒二进制位.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                0b0000_0010_1001_0100_0001_1110_1001_1100
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                0b00111001011110000010100101000000
        );
    }

    @Code(info = """
            颠倒给定的 32 位无符号整数的二进制位。

             

            示例 1：

            输入: 00000010100101000001111010011100
            输出: 00111001011110000010100101000000
            解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
                 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
            示例 2：

            输入：11111111111111111111111111111101
            输出：10111111111111111111111111111111
            解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
                 因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
             

            提示：

            请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
            在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
             

            进阶:
            如果多次调用这个函数，你将如何优化你的算法？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-bits
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        n = (n >>> 16) | (n << 16);
        LOGGER.info("n = {}", Integer.toBinaryString(n));
        //0001_1110_1001_1100  0000_0010_1001_0100

        n = ((n >>> 8) & 0x00ff00ff) | ((n << 8) & (~0x00ff00ff));
        LOGGER.info("n = {}", Integer.toBinaryString(n));
        // 1001_1100  0001_1110  --   1001_0100  0000_0010

        // 1001 1100  0001 1110       1001 0100  0000 0010

        n = ((n >>> 4) & 0x0f0f0f0f) | ((n << 4) & (~0x0f0f0f0f));
        LOGGER.info("n = {}", Integer.toBinaryString(n));
        // 1100 1001  1110 0001   --  0100 1001   0010 0000

        // 1100 1001  1110 0001       0100 1001   0010 0000

        n = ((n >>> 2) & 0x33333333) | ((n << 2) & (~0x33333333));
        LOGGER.info("n = {}", Integer.toBinaryString(n));
        // 0011 0110  1011 0100   --  0001 0110   1000 0000
        // 1000 1100  000101101001000000010010

        n = ((n >>> 1) & 0x55555555) | ((n << 1) & (~0x55555555));
        LOGGER.info("n = {}", Integer.toBinaryString(n));

        return n;
    }
}
