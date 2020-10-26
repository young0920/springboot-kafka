//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1283 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 回文数
 *
 * @author young
 */
class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        // TO TEST
    }

    /**
     * 回文数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            return x == reverse(x);
        }

        private int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                if (rev > Integer.MAX_VALUE / 10
                        || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                rev = rev * 10 + pop;
                x /= 10;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}