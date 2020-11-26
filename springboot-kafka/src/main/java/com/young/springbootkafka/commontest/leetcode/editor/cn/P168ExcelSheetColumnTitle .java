//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 288 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * Excel表列名称
 *
 * @author young
 */
class P168ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new P168ExcelSheetColumnTitle().new Solution();
        // TO TEST
        System.out.println(solution.convertToTitle(701));
    }

    /**
     * Excel表列名称
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int n) {
            StringBuilder stringBuilder = new StringBuilder();
            while (n != 0) {
                stringBuilder.append((char) ('A' + --n % 26));
                n /= 26;
            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}