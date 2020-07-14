package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 重复的DNA序列
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0187重复的DNA序列 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0187重复的DNA序列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

            编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

             

            示例：

            输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
            输出：["AAAAACCCCC", "CCCCCAAAAA"]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/repeated-dna-sequences
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> findRepeatedDnaSequences(String s) {
        return null;
    }
}
