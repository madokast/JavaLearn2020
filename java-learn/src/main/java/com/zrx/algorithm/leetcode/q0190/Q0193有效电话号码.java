package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 有效电话号码
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0193有效电话号码 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0193有效电话号码.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                this.fun(true)
        );
    }

    @Code(info = """
            给定一个包含电话号码列表（一行一个电话号码）的文本文件 file.txt，写一个 bash 脚本输出所有有效的电话号码。

            你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）

            你也可以假设每行前后没有多余的空格字符。

            示例:

            假设 file.txt 内容如下：

            987-123-4567
            123 456 7890
            (123) 456-7890
            你的脚本应当输出下列有效的电话号码：

            987-123-4567
            (123) 456-7890

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/valid-phone-numbers
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "cat file.txt|awk '/^([0-9]{3}-|\\([0-9]{3}\\) )[0-9]{3}-[0-9]{4}$/{print}'";
    }
}
