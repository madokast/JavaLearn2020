package com.zrx.algorithm.leetcode.object.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description
 * leet code 图
 * <p>
 * Data
 * 2020/6/21-17:27
 *
 * @author zrx
 * @version 1.0
 */

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }


    /**
     * 广度优先遍历
     *
     * @param enter 图的入口
     * @return List<Node>
     */
    public static List<Node> traversalBFS(Node enter) {
        List<Node> ret = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.push(enter);
        ret.add(enter);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            for (Node neighbor : pop.neighbors) {
                if (!ret.contains(neighbor)) {
                    ret.add(neighbor);
                    //System.out.println("neighbor = " + neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return ret;
    }


    /**
     * 深度优先遍历
     *
     * @param enter 图的入口
     * @return List<Node>
     */
    public static List<Node> traversalDFS(Node enter) {
        List<Node> ret = new ArrayList<>();

        traversalDFS(enter, ret);

        return ret;
    }

    // 深度优先遍历 helper
    private static void traversalDFS(Node enter, List<Node> ret) {
        if (!ret.contains(enter)) {
            ret.add(enter);
            for (Node neighbor : enter.neighbors) {
                traversalDFS(neighbor, ret);
            }
        }

    }

    // 克隆图 递归法 深度优先遍历
    public static Node cloneDFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNewNodeMap = new HashMap<>();
        cloneDFS0(node, oldNewNodeMap);
        return oldNewNodeMap.get(node);
    }

    // 克隆图 递归法 深度优先遍历 helper
    private static void cloneDFS0(Node node, Map<Node, Node> oldNewNodeMap) {
        Node curNode = new Node(node.val);
        curNode.neighbors = new ArrayList<>(node.neighbors.size());
        oldNewNodeMap.put(node, curNode);

        for (Node neighbor : node.neighbors) {
            if (!oldNewNodeMap.containsKey(neighbor)) {
                cloneDFS0(neighbor, oldNewNodeMap);
            }
            curNode.neighbors.add(oldNewNodeMap.get(neighbor));
        }
    }

    // 克隆图 广度优先搜素
    public static Node cloneBFS(Node node) {
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

    @Override
    public String toString() {
        String str = "[" + val + "->";
        String join = neighbors.stream().map(Node::getVal).map(String::valueOf).collect(Collectors.joining(","));

        return str + join + "]";
    }

    public int getVal() {
        return val;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
