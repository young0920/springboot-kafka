//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 784 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import com.young.springbootkafka.pojo.ListNode;

/**
 * 回文链表
 *
 * @author young
 */
class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
        // TO TEST
    }
    /**
     * 回文链表
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            long hash1 = 0, hash2 = 0, h = 1;
            //seed质数
            long seed = (long) (1e9 + 7);
            ListNode p = head;
            while (p != null) {
                hash1 = hash1 * seed + p.val;
                hash2 += h * p.val;
                h *= seed;
                p = p.next;
            }
            return hash1 == hash2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}