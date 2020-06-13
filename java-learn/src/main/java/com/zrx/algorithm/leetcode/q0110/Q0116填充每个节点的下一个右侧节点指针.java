package com.zrx.algorithm.leetcode.q0110;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 填充每个节点的下一个右侧节点指针
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0116填充每个节点的下一个右侧节点指针 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0116填充每个节点的下一个右侧节点指针.class);


    @Override
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
            给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

            struct Node {
              int val;
              Node *left;
              Node *right;
              Node *next;
            }
            填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

            初始状态下，所有 next 指针都被设置为 NULL。

             

            示例：



            输入：{"id":"1","left":{"id":"2","left":{"id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"id":"5","left":{"id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

            输出：{"id":"1","left":{"id":"2","left":{"id":"3","left":null,"next":{"id":"4","left":null,"next":{"id":"5","left":null,"next":{"id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

            解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
             

            提示：

            你只能使用常量级额外空间。
            使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public Node connect递归(Node root) {
        connect递归0(root, null);
        return root;
    }

    private void connect递归0(Node left, Node right) {
        if (left != null) {
            left.next = right;
            connect递归0(left.left, left.right);
        }

        if (right != null) connect递归0(right.left, right.right);

        if (left != null && right != null) connect递归0(left.right, right.left);
    }


    public Node connect队列(Node root) {
        if (root == null) return null;

        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Deque<Node> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (queue.isEmpty()) node.next = null;
                else node.next = queue.peekFirst();

                if (node.left != null) nextQueue.addLast(node.left);
                if (node.right != null) nextQueue.addLast(node.right);
            }

            queue = nextQueue;
        }

        return root;
    }
}
