package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 同构字符串
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0205同构字符串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0205同构字符串.class);

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
            给定两个字符串 s 和 t，判断它们是否是同构的。

            如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

            所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

            示例 1:

            输入: s = "egg", t = "add"
            输出: true
            示例 2:

            输入: s = "foo", t = "bar"
            输出: false
            示例 3:

            输入: s = "paper", t = "title"
            输出: true
            说明:
            你可以假设 s 和 t 具有相同的长度。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/isomorphic-strings
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isIsomorphic(String s, String t) {
        return false;
    }
}
