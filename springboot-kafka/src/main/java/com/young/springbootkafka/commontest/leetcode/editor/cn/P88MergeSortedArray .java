//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 691 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 合并两个有序数组
 *
 * @author young
 */
class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
        int[] num1 = new int[]{1, 2, 3, 4, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        solution.merge(num1, 3, num2, 3);
    }

    /**
     * 合并两个有序数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int right1 = m - 1;
            int right2 = n - 1;
            int len = m + n - 1;
            while (right1 >= 0 && right2 >= 0) {
                if (nums1[right1] >= nums2[right2]) {
                    nums1[len--] = nums1[right1--];
                } else {
                    nums1[len--] = nums2[right2--];
                }
            }
            while (right2 >= 0) {
                nums1[len--] = nums2[right2--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}