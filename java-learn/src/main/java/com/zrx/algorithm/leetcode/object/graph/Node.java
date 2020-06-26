package com.zrx.algorithm.leetcode.object.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
                    System.out.println("neighbor = " + neighbor);
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
