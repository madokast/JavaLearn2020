package com.zrx.algorithm.leetcode.object;

import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 构造二叉树
     *
     * @param values leet code 中的二叉树表示数组
     * @return 二叉树
     */
    public static TreeNode of(Integer... values) {
        Objects.requireNonNull(values);
        Integer first = values[0];
        TreeNode root = new TreeNode(first);

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Boolean> leftQueue = new LinkedList<>();

        treeNodeQueue.offer(root);
        leftQueue.offer(true);
        treeNodeQueue.offer(root);
        leftQueue.offer(false);

        for (int i = 1; i < values.length; i++) {
            Integer value = values[i];

            TreeNode treeNode = treeNodeQueue.poll();
            Boolean left = leftQueue.poll();

            if (value != null) {
                TreeNode child = new TreeNode(value);
                if (left) {
                    treeNode.left = child;
                } else {
                    treeNode.right = child;
                }

                treeNodeQueue.offer(child);
                leftQueue.offer(true);
                treeNodeQueue.offer(child);
                leftQueue.offer(false);
            }
        }

        return root;
    }

    /**
     * @return 把树转为 leet code 风格的数组形式
     */
    public List<Integer> toLeetCodeFormArray() {
        TreeNode root = this;
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> curQueue = new LinkedList<>();
        curQueue.offer(root);

        while (!curQueue.isEmpty()) {
            TreeNode poll = curQueue.poll();
            if (poll == null) {
                ret.add(null);
            } else {
                ret.add(poll.val);
                curQueue.offer(poll.left);
                curQueue.offer(poll.right);
            }
        }

        while (ret.get(ret.size() - 1) == null) ret.remove(ret.size() - 1);

        return ret;
    }

    /**
     * @return leet code 风格字符串
     */
    @Override
    public String toString() {
        return toLeetCodeFormArray().stream()
                .map(e -> e == null ? "nu" : e.toString())
                .collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * 转为字符串，保有树结构。如
     * <pre>
     *          1
     *        2   3
     *   nu  nu   6   7
     * </pre>
     *
     * @param layers     最大层数
     * @param itemLength 每个节点占字符数目，少则用空格填充
     * @return 字符串，保有树结构
     */
    public String toTreeString(int layers, int itemLength) {

        List<StringBuilder> stringBuilders = new ArrayList<>(layers);

        TreeNode root = this;
        Queue<TreeNode> curQueue = new LinkedList<>();
        curQueue.offer(root);


        for (int i = 0; i < layers; i++) {
            Queue<TreeNode> nextQueue = new LinkedList<>();

            if (!isAllNull(curQueue)) {
                StringBuilder sb = new StringBuilder();
                stringBuilders.add(sb);

                while (!curQueue.isEmpty()) {
                    TreeNode poll = curQueue.poll();
                    sb.append(String.format("%" + itemLength + "s", poll == null ? "nu" : poll.val));
                    if (poll != null) {
                        nextQueue.offer(poll.left);
                        nextQueue.offer(poll.right);
                    } else {
                        nextQueue.offer(null);
                        nextQueue.offer(null);
                    }
                }
            } else break;

            curQueue = nextQueue;
        }

        int size = stringBuilders.size();
        int lastLength = stringBuilders.get(size - 1).length();

        return "\n" + stringBuilders.stream()
                .peek(stringBuilder -> {
                    int length = stringBuilder.length();
                    stringBuilder.insert(0, " ".repeat((lastLength - length) / 2));
                })
                .collect(Collectors.joining("\n"));
    }

    /**
     * 集合中元素是否全为 null
     *
     * @param collection 集合
     * @return 元素是否全空
     */
    private boolean isAllNull(Iterable<?> collection) {
        Objects.requireNonNull(collection);
        boolean flag = true;
        for (Object o : collection) {
            if (o != null) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;

        Queue<TreeNode> thisQueue = new LinkedList<>();
        thisQueue.offer(this);

        Queue<TreeNode> thatQueue = new LinkedList<>();
        thatQueue.offer(treeNode);

        while (!thisQueue.isEmpty()) {
            if (thatQueue.isEmpty()) return false;

            TreeNode thisNode = thisQueue.poll();
            TreeNode thatNode = thatQueue.poll();

            if (thisNode.val != thatNode.val) return false;
            else {
                if (thisNode.left != null) {
                    if (thatNode.left == null) return false;

                    thisQueue.offer(thisNode.left);
                    thatQueue.offer(thatNode.left);
                }

                if (thisNode.right != null) {
                    if (thatNode.right == null) return false;

                    thisQueue.offer(thisNode.right);
                    thatQueue.offer(thatNode.right);
                }
            }
        }

        Assert.isTrue(thatQueue.isEmpty(), "TreeNode#equals方法有错误!");

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toLeetCodeFormArray());
    }

    // 先序(preorder)，中序（inorder），后序(postorder) 遍历 Traversal 方法

    /**
     * 中序遍历 - 颜色标记法
     * @param root 根
     * @return 遍历结果数组
     */
    public static List<Integer> inorderTraversalColor(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Boolean> colorStack = new LinkedList<>();

        nodeStack.push(root);
        colorStack.push(false);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Boolean color = colorStack.pop();

            if (node == null) {
                continue;
            }

            if (color) {
                list.add(node.val);
            } else {
                nodeStack.push(node.right);
                nodeStack.push(node);
                nodeStack.push(node.left);

                colorStack.push(false);
                colorStack.push(true);
                colorStack.push(false);
            }
        }

        return list;
    }

    /**
     * 中序遍历 - 非递归法
     * @param root 根
     * @return 遍历结果数组
     */
    public static List<Integer> inorderTraversalNoRecursive(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (stack.peek().left != null) stack.push(stack.peek().left);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            list.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
                while (stack.peek().left != null) stack.push(stack.peek().left);
            }
        }

        return list;
    }

    /**
     * 中序遍历 - 递归法
     * @param root 根
     * @return 遍历结果数组
     */
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    /**
     * 中序遍历 - 递归法 递归方法
     * @param node 当前节点
     * @param list 中途数组
     */
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node.left != null) inorderTraversal(node.left, list);
        list.add(node.val);
        if (node.right != null) inorderTraversal(node.right, list);
    }
}
