package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同的二叉搜索树
 * <p>
 * Data
 * 2020/6/6-16:34
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0096不同的二叉搜索树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0096不同的二叉搜索树.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

            示例:

            输入: 3
            输出: 5
            解释:
            给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

               1         3     3      2      1
                \\       /     /      / \\      \\
                 3     2     1      1   3      2
                /     /       \\                 \\
               2     1         2                 3

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/unique-binary-search-trees
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int numTrees(int n) {
        return 0;
    }
}
