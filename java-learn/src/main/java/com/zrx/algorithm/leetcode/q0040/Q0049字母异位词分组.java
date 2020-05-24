package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2020/5/24-21:42
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0049字母异位词分组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0049字母异位词分组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create("eat", "tea", "tan", "ate", "nat", "bat")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of("ate","eat","tea"),
                        RepeatableSet.of("nat","tan"),
                        RepeatableSet.of("bat")
                )
        );
    }

    @Code(info = """
            给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

            示例:

            输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
            输出:
            [
              ["ate","eat","tea"],
              ["nat","tan"],
              ["bat"]
            ]
            说明：

            所有输入均为小写字母。
            不考虑答案输出的顺序。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/group-anagrams
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }
}
