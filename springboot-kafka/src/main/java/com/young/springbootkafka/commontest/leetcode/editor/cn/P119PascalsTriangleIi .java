//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 199 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @author young
 */
class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        // TO TEST
        System.out.println(solution.getRow(3));
    }

    /**
     * 杨辉三角 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
/*            int pre = 1;
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                for (int j = 1; j < i; j++) {
                    int temp = cur.get(j);
                    cur.set(j, pre + cur.get(j));
                    pre = temp;
                }
                cur.add(1);
            }
            return cur;*/
            //公式法
            List<Integer> ans = new ArrayList<>();
            long pre = 1;
            ans.add(1);
            for (int k = 1; k <= rowIndex; k++) {
                long cur = pre * (rowIndex - k + 1) / k;
                ans.add((int) cur);
                pre = cur;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}