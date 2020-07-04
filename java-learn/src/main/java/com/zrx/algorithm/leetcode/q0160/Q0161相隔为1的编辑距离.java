package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 相隔为 1 的编辑距离
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0161相隔为1的编辑距离 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0161相隔为1的编辑距离.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create();
    }

    @Code(info = """
            给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。

            注意：

            满足编辑距离等于 1 有三种可能的情形：

            往 s 中插入一个字符得到 t
            从 s 中删除一个字符得到 t
            在 s 中替换一个字符得到 t
            示例 1：

            输入: s = "ab", t = "acb"
            输出: true
            解释: 可以将 'c' 插入字符串 s 来得到 t。
            示例 2:

            输入: s = "cab", t = "ad"
            输出: false
            解释: 无法通过 1 步操作使 s 变为 t。
            示例 3:

            输入: s = "1203", t = "1213"
            输出: true
            解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/one-edit-distance
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean isOneEditDistance(String s, String t) {
        return false;
    }
}
