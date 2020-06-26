package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 复制带随机指针的链表
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0138复制带随机指针的链表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0138复制带随机指针的链表.class);

    @Override
    public List<Input> getInputs() {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node1.next = null;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;


        return InputFactory.create(
                1, node7
        );
    }

    @Override
    public List<Answer> getAnswers() {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node1.next = null;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        return AnswerFactory.create(node7);
    }

    @Code(info = """
            给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

            要求返回这个链表的 深拷贝。 

            我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

            val：一个表示 Node.val 的整数。
            random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
             
            示例 1：

            输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
            输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
            示例 2：


            输入：head = [[1,1],[2,1]]
            输出：[[1,1],[2,1]]
            示例 3：


            输入：head = [[3,null],[3,0],[3,null]]
            输出：[[3,null],[3,0],[3,null]]
            示例 4：

            输入：head = []
            输出：[]
            解释：给定的链表为空（空指针），因此返回 null。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public Node copyRandomList(Node head) {

        Map<Node, Node> oldNewNode = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        oldNewNode.put(head, new Node(head.val));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
//            oldNewNode.put(poll, new Node(poll.val));

            Node next = poll.next;
            Node random = poll.random;

            if (next != null && !oldNewNode.containsKey(next)) {
                oldNewNode.put(next, new Node(next.val));
                queue.add(next);
            }
            if (random != null && !oldNewNode.containsKey(random)) {
                oldNewNode.put(random, new Node(random.val));
                queue.add(random);
            }

            if (next != null) {
//                if (!oldNewNode.containsKey(next)) queue.add(next);
                LOGGER.info("next = {}", next);

                oldNewNode.get(poll).next = oldNewNode.get(next);
            }

            if (random != null) {
//                if (!oldNewNode.containsKey(random)) queue.add(random);

                oldNewNode.get(poll).random = oldNewNode.get(random);
            }
        }

        LOGGER.info("oldNewNode = {}", oldNewNode);

        return oldNewNode.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + (next == null ? null : next.val) +
                    ", random=" + (random == null ? null : random.val) +
                    '}';
        }
    }

}
