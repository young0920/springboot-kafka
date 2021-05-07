//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 355 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 两个数组的交集
 *
 * @author young
 */
class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }

    /**
     * 两个数组的交集
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int n = nums1.length;
            int m = nums2.length;

            int i = 0, j = 0;
            HashSet<Integer> set = new HashSet<>(); // 存储时会去重
            while (i < n && j < m) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) { // 谁小，谁的指针需要往后移动
                    i++;
                } else {
                    j++;
                }
            }
            int[] res = new int[set.size()];
            int index = 0;
            for (int num : set) {
                res[index++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}