//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 425 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import com.young.springbootkafka.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * @author young
 */ 
class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
        // TO TEST
    }
    /**
    * 二叉树的所有路径
    */ 
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        //传根节点进入dfs递归，根节点时传入的路径为空
        dfs(root, "", list);
        return list;
    }

    private void dfs(TreeNode root, String path, List<String> list) {
        //判断是否为空
        if(root == null) {
            return;
        }
        //判断是否为叶子结点（即：无左子树无右子树）
        if(root.left == null && root.right == null) {
            list.add(path + root.val);
            return;
        }
        //递归调用dfs，先传入左结点，后传入右结点直到输出完整的路径
        dfs(root.left, path + root.val + "->", list);
        dfs(root.right, path + root.val + "->", list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}