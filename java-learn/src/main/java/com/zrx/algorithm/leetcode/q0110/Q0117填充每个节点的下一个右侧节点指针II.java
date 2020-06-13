package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 填充每个节点的下一个右侧节点指针 II
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0117填充每个节点的下一个右侧节点指针II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0117填充每个节点的下一个右侧节点指针II.class);

    public List<Input> getInputs() {
        Node root = new Node();
        Node left = new Node();
        Node right = new Node();

        root.val = 1;
        root.left = left;
        root.right = right;

        left.val = 2;
        right.val = 3;


        return InputFactory.create(1, root);
    }

    @Override
    public List<Answer> getAnswers() {
        Node root = new Node();
        Node left = new Node();
        Node right = new Node();

        root.val = 1;
        root.left = left;
        root.right = right;

        left.val = 2;
        right.val = 3;

        root.next = null;
        left.next = right;
        right.next = null;

        return AnswerFactory.create(root);
    }

    @Code(info = """
            给定一个二叉树

            struct Node {
              int val;
              Node *left;
              Node *right;
              Node *next;
            }
            填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

            初始状态下，所有 next 指针都被设置为 NULL。

             

            进阶：

            你只能使用常量级额外空间。
            使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
             

            示例：



            输入：root = [1,2,3,4,5,null,7]
            输出：[1,#,2,3,#,4,5,7,#]
            解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
             

            提示：

            树中的节点数小于 6000
            -100 <= node.val <= 100

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public Node connect(Node root) {
        if (root == null) return null;
        root.next = null;

        Node leftMost = root;
        while (leftMost != null) {
            Node t = leftMost;

            while (leftMost != null) {
                wps(leftMost);
                leftMost = leftMost.next;
            }

            while (t != null) {
                Node left = t.left;
                Node right = t.right;

                if (left != null) {
                    leftMost = left;
                    break;
                }

                if (right != null) {
                    leftMost = right;
                    break;
                }

                t = t.next;
            }
        }

        return root;
    }

    private void wps(Node father) {
        Node left = father.left;
        Node right = father.right;
        Node next = father.next;

        Node rightNext = null;
        while (next != null) {
            Node nl = next.left;
            Node nr = next.right;

            if (nl != null) {
                rightNext = nl;
                break;
            }

            if (nr != null) {
                rightNext = nr;
                break;
            }

            next = next.next;
        }

        if (left != null) {
            if (right != null) left.next = right;
            else left.next = rightNext;
        }

        if (right != null) right.next = rightNext;
    }


}
