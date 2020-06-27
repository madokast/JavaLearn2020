package com.zrx.algorithm.leetcode.q0130;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.graph.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 克隆图
 * <p>
 * Data
 * 2020/6/21-17:20
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class q0133克隆图 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(q0133克隆图.class);

    @Override
    public List<Input> getInputs() {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 1;
        Node n3 = new Node();
        n3.val = 1;
        Node n4 = new Node();
        n4.val = 1;

        n1.neighbors = List.of(n2, n4);
        n2.neighbors = List.of(n1, n3);
        n3.neighbors = List.of(n2, n4);
        n4.neighbors = List.of(n1, n3);

        Node empty = new Node();
        empty.val = 1;


        return InputFactory.create(
                1,
                n1, empty
        );
    }

    @Override
    public List<Answer> getAnswers() {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 1;
        Node n3 = new Node();
        n3.val = 1;
        Node n4 = new Node();
        n4.val = 1;

        n1.neighbors = List.of(n2, n4);
        n2.neighbors = List.of(n1, n3);
        n3.neighbors = List.of(n2, n4);
        n4.neighbors = List.of(n1, n3);

        Node empty = new Node();
        empty.val = 1;

        return AnswerFactory.create(n1, empty);
    }

    @Code(info = """
            给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

            图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

            class Node {
                public int val;
                public List<Node> neighbors;
            }
             

            测试用例格式：

            简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。

            邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。

            给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。

            示例 1：


            输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
            输出：[[2,4],[1,3],[2,4],[1,3]]
            解释：
            图中有 4 个节点。
            节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
            节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
            节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
            节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
            示例 2：

            输入：adjList = [[]]
            输出：[[]]
            解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
            示例 3：

            输入：adjList = []
            输出：[]
            解释：这个图是空的，它不含任何节点。
            示例 4：


            输入：adjList = [[2],[1]]
            输出：[[2],[1]]

            提示：

            节点数不超过 100 。
            每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
            无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
            由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
            图是连通图，你可以从给定节点访问到所有节点。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/clone-graph
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public Node cloneGraph二刷广度优先搜索(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNewNodeMap = new HashMap<>();

        Queue<Node> nodeQueue = new LinkedList<>();

        Node enter = new Node(node.val);
        enter.neighbors = new ArrayList<>(node.neighbors.size());
        oldNewNodeMap.put(node, enter);
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();

            for (Node neighbor : poll.neighbors) {
                if (!oldNewNodeMap.containsKey(neighbor)) {
                    Node n = new Node(neighbor.val);
                    n.neighbors = new ArrayList<>(neighbor.neighbors.size());
                    oldNewNodeMap.put(neighbor, n);
                    nodeQueue.offer(neighbor);
                }

                oldNewNodeMap.get(poll).neighbors.add(oldNewNodeMap.get(neighbor));
            }
        }

        return oldNewNodeMap.get(node);
    }


    public Node cloneGraph二刷递归(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNewNodeMap = new HashMap<>();
        cloneGraph二刷递归(node, oldNewNodeMap);
        return oldNewNodeMap.get(node);
    }

    public void cloneGraph二刷递归(Node node, Map<Node, Node> oldNewNodeMap) {
        Node curNode = new Node(node.val);
        curNode.neighbors = new ArrayList<>(node.neighbors.size());
        oldNewNodeMap.put(node, curNode);

        for (Node neighbor : node.neighbors) {
            if (!oldNewNodeMap.containsKey(neighbor)) {
                cloneGraph二刷递归(neighbor, oldNewNodeMap);
            }
            curNode.neighbors.add(oldNewNodeMap.get(neighbor));
        }
    }


    public Node cloneGraph一刷(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> queue = new ArrayDeque<>(100);

        queue.offer(node);

        visited.put(node, new Node(node.val, new ArrayList<>(node.neighbors.size())));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (Node neighbor : poll.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>(neighbor.neighbors.size())));
                    queue.add(neighbor);
                }
                visited.get(poll).neighbors.add(visited.get(neighbor));
            }
        }


        return visited.get(node);
    }


    public Node cloneGraph递归(Node node) {
        if (node == null) return null;

        if (map == null) map = new HashMap<>();

        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            Node clone = new Node();
            map.put(node, clone);
            clone.val = node.val;
            clone.neighbors = new ArrayList<>();
            node.neighbors.forEach(n -> clone.neighbors.add(cloneGraph递归(n)));
            return clone;
        }
    }

    private Map<Node, Node> map = null;
}
