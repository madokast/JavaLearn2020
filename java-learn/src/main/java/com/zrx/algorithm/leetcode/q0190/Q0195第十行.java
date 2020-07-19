package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 第十行
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0195第十行 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0195第十行.class);

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
            给定一个文本文件 file.txt，请只打印这个文件中的第十行。

            示例:

            假设 file.txt 有如下内容：

            Line 1
            Line 2
            Line 3
            Line 4
            Line 5
            Line 6
            Line 7
            Line 8
            Line 9
            Line 10
            你的脚本应当显示第十行：

            Line 10
            说明:
            1. 如果文件少于十行，你应当输出什么？
            2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/tenth-line
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return null;
    }
}
