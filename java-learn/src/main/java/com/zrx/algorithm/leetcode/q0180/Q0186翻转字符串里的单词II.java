package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 翻转字符串里的单词 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0186翻转字符串里的单词II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0186翻转字符串里的单词II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
        );
    }

    @Code(info = """
            给定一个字符串，逐个翻转字符串中的每个单词。

            示例：

            输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
            输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
            注意：

            单词的定义是不包含空格的一系列字符
            输入字符串中不会包含前置或尾随的空格
            单词与单词之间永远是以单个空格隔开的
            进阶：使用 O(1) 额外空间复杂度的原地解法。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public void reverseWords(char[] s) {

    }
}
