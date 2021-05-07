//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 209 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 有效的完全平方数
 *
 * @author young
 */
class P367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new P367ValidPerfectSquare().new Solution();
        // TO TEST
        System.out.println(solution.isPerfectSquare(808201));
    }

    /**
     * 有效的完全平方数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            long low = 1;
            long high = num / 2;
            if (num < 2) {
                return true;
            }
            while (low <= high) {
                long mid = low + (high - low) / 2;
                long res = mid * mid;
                if (res == num) {
                    return true;
                } else if (res > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}