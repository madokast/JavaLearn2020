package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 统计词频
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0192统计词频 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0192统计词频.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                this.fun(true)
        );
    }

    @Code(info = """
            写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。

            为了简单起见，你可以假设：

            words.txt只包括小写字母和 ' ' 。
            每个单词只由小写字母组成。
            单词间由一个或多个空格字符分隔。
            示例:

            假设 words.txt 内容如下：

            the day is sunny the the
            the sunny is is
            你的脚本应当输出（以词频降序排列）：

            the 4
            is 3
            sunny 2
            day 1
            说明:

            不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。
            你可以使用一行 Unix pipes 实现吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-frequency
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "cat words.txt |awk '!/^*$/{print}'|tr -s ' ' '\\n' |sort|uniq -c|sort -rn|awk '{print $2,$1}'";
    }
}
