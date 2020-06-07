package com.zrx.algorithm.leetcode.object;

import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class TreeNode {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(TreeNode.class);

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
