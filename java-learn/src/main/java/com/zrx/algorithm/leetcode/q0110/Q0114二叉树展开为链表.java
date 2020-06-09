package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 二叉树展开为链表
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0114二叉树展开为链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0114二叉树展开为链表.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个二叉树，原地将它展开为一个单链表。

             

            例如，给定二叉树

                1
               / \\
              2   5
             / \\   \\
            3   4   6
            将其展开为：

            1
             \\
              2
               \\
                3
                 \\
                  4
                   \\
                    5
                     \\
                      6

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public void flatten(TreeNode root) {

    }
}
