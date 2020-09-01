package com.zrx.algorithm.leetcode.q0290;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * 单词规律
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0290单词规律 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0290单词规律.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "abba", "dog cat cat dog",
                "abba", "dog cat cat fish",
                "aaaa", "dog cat cat dog",
                "abba", "dog dog dog dog"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true, false, false, false
        );
    }

    @Code(info = """
            给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

            这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

            示例1:

            输入: pattern = "abba", str = "dog cat cat dog"
            输出: true
            示例 2:

            输入:pattern = "abba", str = "dog cat cat fish"
            输出: false
            示例 3:

            输入: pattern = "aaaa", str = "dog cat cat dog"
            输出: false
            示例 4:

            输入: pattern = "abba", str = "dog dog dog dog"
            输出: false
            说明:
            你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。   

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-pattern
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        int pLen = p.length;

        String[] ss = str.split(" ");
        int sLen = ss.length;

        if (pLen != sLen) return false;
        if (pLen == 1) return true;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mmap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char c = p[i];
            String s = ss[i];

            if (map.containsKey(c)) {
                String sp = map.get(c);
                if (!sp.equals(s)) return false;
            } else {
                map.put(c, s);
            }

            if (mmap.containsKey(s)) {
                Character cp = mmap.get(s);
                if (!cp.equals(c)) return false;
            } else {
                mmap.put(s, c);
            }
        }


        return true;
    }
}
