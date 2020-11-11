//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2615 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 最大子序和
 *
 * @author young
 */
class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
    }

    /**
     * 最大子序和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int dp = 0;
            for (int num : nums) {
                if (dp > 0) {
                    dp += num;
                } else {
                    dp = num;
                }
                res = Math.max(dp, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}