//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2291 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 整数反转
 *
 * @author young
 */
class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }

    /**
     * 整数反转
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int rev = 0;//rev存储反转的数字
            while (x != 0) {
                int pop = x % 10;//pop表示弹出的数
                //如果已经反转内容rev大于Integr最大值/10,那么一定溢出；
                // 如果最rev反转内容等于最大值/10且最后一位pop的数字大于7，那么就从正数这边溢出了
                //另外一种就是从负数那边溢出了
                boolean flag = (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                        || rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8);
                if (flag) {
                    return 0;
                }
                rev = rev * 10 + pop;//把pop防到rev后面
                x /= 10;//去掉已经pop的内容
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}