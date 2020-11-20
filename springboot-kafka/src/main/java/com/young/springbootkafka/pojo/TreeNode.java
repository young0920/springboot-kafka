package com.young.springbootkafka.pojo;

/**
 * TreeNode
 *
 * @author yangbing
 * @date 2020/11/20 下午4:57
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
