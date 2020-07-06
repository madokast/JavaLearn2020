package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Excel表列序号
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0171Excel表列序号 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0171Excel表列序号.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            给定一个Excel表格中的列名称，返回其相应的列序号。

            例如，

                A -> 1
                B -> 2
                C -> 3
                ...
                Z -> 26
                AA -> 27
                AB -> 28\040
                ...
            示例 1:

            输入: "A"
            输出: 1
            示例 2:

            输入: "AB"
            输出: 28
            示例 3:

            输入: "ZY"
            输出: 701
            致谢：
            特别感谢 @ts 添加此问题并创建所有测试用例。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/excel-sheet-column-number
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int titleToNumber(String s) {
return -1;
    }
}
