package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * Excel表列名称
 * 难题：看了答案的，背下来
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0168Excel表列名称 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0168Excel表列名称.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                1, 28, 701
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "A", "AB", "ZY"
        );
    }

    @Code(info = """
            给定一个正整数，返回它在 Excel 表中相对应的列名称。

            例如，

                1 -> A
                2 -> B
                3 -> C
                ...
                26 -> Z
                27 -> AA
                28 -> AB\040
                ...
            示例 1:

            输入: 1
            输出: "A"
            示例 2:

            输入: 28
            输出: "AB"
            示例 3:

            输入: 701
            输出: "ZY"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/excel-sheet-column-title
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> resList = new LinkedList<>();

        int offset = 'A';

        while (n > 0) {
            n--;
            int res = n % 26;
            n = n / 26;
            sb.append((char) (res + offset));
        }


        return sb.reverse().toString();
    }

    private String repeat(String a, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(a);
        }

        return sb.toString();
    }

    private boolean all25(LinkedList<Integer> resList) {
        for (Integer integer : resList) {
            if (integer != 25)
                return false;
        }

        return true;
    }
}
