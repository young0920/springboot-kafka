//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1342 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 爬楼梯
 *
 * @author young
 */
class P70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new P70ClimbingStairs().new Solution();
        // TO TEST
        long time = System.currentTimeMillis();
        System.out.println(solution.climbStairs(4));
        System.out.println(System.currentTimeMillis() - time);
    }

    /**
     * 爬楼梯
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int res1 = 1, res2 = 2, result = 0;
            while (n - 2 > 0) {
                result = res1 + res2;
                res1 = res2;
                res2 = result;
                n--;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}