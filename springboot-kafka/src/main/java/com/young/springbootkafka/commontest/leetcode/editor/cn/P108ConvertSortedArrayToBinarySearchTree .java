//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 638 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import com.young.springbootkafka.pojo.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author young
 */
class P108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P108ConvertSortedArrayToBinarySearchTree().new Solution();
        // TO TEST
        System.out.println(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
    /**
     * 将有序数组转换为二叉搜索树
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return convertToBST(nums, 0, nums.length - 1);
        }

        private TreeNode convertToBST(int[] nums, int begin, int end) {
            if (begin > end) {
                return null;
            }
            //取中值
            int mid = begin + (end - begin) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            //左叶子树
            root.left = convertToBST(nums, begin, mid - 1);
            //右叶子树
            root.right = convertToBST(nums, mid + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}