//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 263 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 2的幂
 *
 * @author young
 */
class P231PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        // TO TEST
        System.out.println(solution.isPowerOfTwo(16));
    }

    /**
     * 2的幂
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >> 1;
                if (count > 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}