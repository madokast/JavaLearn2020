package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.algorithm.leetcode.object.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

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

@SuppressWarnings("all")
@Component
public class Q0095不同的二叉搜索树II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0095不同的二叉搜索树II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        TreeNode.of(1, null, 3, 2),
                        TreeNode.of(3, 2, null, 1),
                        TreeNode.of(3, 1, null, null, 2),
                        TreeNode.of(2, 1, 3),
                        TreeNode.of(1, null, 2, null, 3)
                )
        );
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
        if (n == 0) return Collections.emptyList();
        return generateTrees(1, n + 1);
    }

    private List<TreeNode> generateTrees(int startIn, int endEx) {
        List<TreeNode> list = new LinkedList<>();
        if (startIn >= endEx) {
            list.add(null);
            return list;
        }

        for (int i = startIn; i < endEx; i++) {
            // i is root
            List<TreeNode> lefts = generateTrees(startIn, i);
            List<TreeNode> rights = generateTrees(i + 1, endEx);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }

        return list;
    }


    public List<TreeNode> generateTrees垃圾方法(int n) {
        if (n == 0) return Collections.emptyList();
        List<TreeNode> list = treeN(n);
        list.forEach(this::fillTreeToBiSearch);

        return list;
    }

    private List<TreeNode> treeN(int n) {
        if (n == 0) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        } else if (n == 1) {
            return List.of(new TreeNode(0));
        } else {
            List<TreeNode> ans = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                List<TreeNode> lefts = treeN(i);
                List<TreeNode> rights = treeN(n - i - 1);

                for (int j = 0; j < lefts.size(); j++) {
                    for (int k = 0; k < rights.size(); k++) {
                        TreeNode left = lefts.get(j);
                        TreeNode right = rights.get(k);


                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;

                        ans.add(root);
                    }
                }
            }

            return ans;
        }
    }

    private void fillTreeToBiSearch(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();

        final Boolean WHITE = true;
        final Boolean GREY = false;

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        Deque<Boolean> colorDeque = new LinkedList<>();

        treeNodeDeque.push(root);
        colorDeque.push(WHITE);

        while (treeNodeDeque.size() != 0) {
            TreeNode treeNode = treeNodeDeque.pop();
            Boolean color = colorDeque.pop();

            if (treeNode == null) continue;

            if (color == WHITE) {
                treeNodeDeque.push(treeNode.right);
                treeNodeDeque.push(treeNode);
                treeNodeDeque.push(treeNode.left);

                colorDeque.push(WHITE);
                colorDeque.push(GREY);
                colorDeque.push(WHITE);
            } else {
                list.add(treeNode);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = i + 1;
        }
    }


    // 神奇
    public <String> void get(String string) {
    }

    class A<T> {
        <T> void fun(T t) {
        }
    }

    class B<T> {
        void fun(T t) {
        }
    }

    //Long a = 0;
    //long a = 0;
}
