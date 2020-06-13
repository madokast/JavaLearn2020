package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 验证回文串
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0125验证回文串 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0125验证回文串.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """

            给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

            说明：本题中，我们将空字符串定义为有效的回文串。

            示例 1:

            输入: "A man, a plan, a canal: Panama"
            输出: true
            示例 2:

            输入: "race a car"
            输出: false
            """)
    public boolean isPalindrome(String s) {
        return false;
    }
}
