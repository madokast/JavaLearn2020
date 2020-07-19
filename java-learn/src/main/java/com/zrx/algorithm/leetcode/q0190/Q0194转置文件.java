package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 转置文件
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0194转置文件 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0194转置文件.class);

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
            给定一个文件 file.txt，转置它的内容。

            你可以假设每行列数相同，并且每个字段由 ' ' 分隔.

            示例:

            假设 file.txt 文件内容如下：

            name age
            alice 21
            ryan 30
            应当输出：

            name alice ryan
            age 21 30

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/transpose-file
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return null;
    }
}
