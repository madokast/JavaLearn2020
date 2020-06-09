package com.zrx.algorithm.leetcode.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * Node
 * <p>
 * Data
 * 2020/6/9-19:39
 *
 * @author zrx
 * @version 1.0
 */

public class Node {
    private final static Logger LOGGER = LoggerFactory.getLogger(Node.class);

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
