//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 368 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import com.young.springbootkafka.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 II
 *
 * @author young
 */
class P107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107BinaryTreeLevelOrderTraversalIi().new Solution();
        // TO TEST
    }
    /**
     * 二叉树的层次遍历 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> oneLevel = new ArrayList<>();
                // 每次都取出一层的所有数据
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    oneLevel.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                // 每次都往队头塞
                result.addFirst(oneLevel);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}