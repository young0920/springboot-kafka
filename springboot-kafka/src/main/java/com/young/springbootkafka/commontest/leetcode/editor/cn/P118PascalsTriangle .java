//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 377 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author young
 */
class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
        // TO TEST
        System.out.println(solution.generate(5));
    }

    /**
     * 杨辉三角
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
/*            List<List<Integer>> result = new ArrayList<>();
            if (numRows == 0) {
                return result;
            }
            //第一行永远是[1]
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                //第一个元素永远是[1]
                row.add(1);
                List<Integer> prevRow = result.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                //最后一个元素永远是[1]
                row.add(1);
                result.add(row);
            }
            return result;*/

            //公式法
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> ans = new ArrayList<>();
                long pre = 1;
                ans.add(1);
                for (int j = 1; j <= i; j++) {
                    long cur = pre * (i - j + 1) / j;
                    ans.add((int) cur);
                    pre = cur;
                }
                result.add(ans);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}