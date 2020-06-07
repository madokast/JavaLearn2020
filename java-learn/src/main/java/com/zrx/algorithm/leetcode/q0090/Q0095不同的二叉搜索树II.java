package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 不同的二叉搜索树 II
 * <p>
 * Data
 * 2020/6/6-16:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0095不同的二叉搜索树II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0095不同的二叉搜索树II.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

             

            示例：

            输入：3
            输出：
            [
              [1,null,3,2],
              [3,2,null,1],
              [3,1,null,null,2],
              [2,1,3],
              [1,null,2,null,3]
            ]
            解释：
            以上的输出对应以下 5 种不同结构的二叉搜索树：

               1         3     3      2      1
                \\       /     /      / \\      \\
                 3     2     1      1   3      2
                /     /       \\                 \\
               2     1         2                 3
             

            提示：

            0 <= n <= 8

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<TreeNode> generateTrees(int n) {
        return null;
    }
}
