//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1592 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;
/**
 * 只出现一次的数字
 * @author young
 */ 
class P136SingleNumber{
    public static void main(String[] args) {
        Solution solution = new P136SingleNumber().new Solution();
        // TO TEST
        System.out.println(solution.singleNumber(new int[]{4,1,2,1,2}));
    }
    /**
    * 只出现一次的数字
    */ 
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            //异或 两个相同的数是0，0异或一个数结果就是那个数
            res ^= num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}