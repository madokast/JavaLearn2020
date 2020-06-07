package com.zrx.algorithm.leetcode.object;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


class TreeNodeTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(TreeNodeTest.class);

    private List<TreeNode> trees() {
        List<TreeNode> ret = new ArrayList<>();

        {
            TreeNode root = new TreeNode(1);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            //root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            //root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            //root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            //root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            //root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            //root.left.left = new TreeNode(4);
            //root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            root.left = null;
            ret.add(root);
        }

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            root.right = null;
            ret.add(root);
        }

        return ret;
    }

    @Test
    void toLeetCodeFormArray() {

    }


    @Test
    void ofTest() {
        trees().forEach(treeNode -> {
            LOGGER.info("test = {}", treeNode.toTreeString(3, 4));
            Integer[] integers = treeNode.toLeetCodeFormArray().toArray(Integer[]::new);

            TreeNode of = TreeNode.of(integers);
            LOGGER.info("of = {}", of.toTreeString(3, 4));
        });
    }

    @Test
    void testToString() {
        trees().forEach(treeNode -> {
            LOGGER.info(treeNode.toTreeString(3, 4));
            LOGGER.info(treeNode.toString());
        });
    }

    @Test
    void toTreeString() {
        trees().forEach(treeNode -> {
            LOGGER.info(treeNode.toTreeString(3, 4));
        });
    }

    @Test
    void testEquals() {
        List<TreeNode> trees = trees();
        List<TreeNode> copy = trees;

        for (int i = 0; i < trees.size(); i++) {
            TreeNode treeNode = trees.get(i);
            TreeNode treeNode1 = copy.get(i);

            Assert.assertEquals(treeNode, treeNode1);
            Assert.assertEquals(treeNode1, treeNode);
        }
    }
}