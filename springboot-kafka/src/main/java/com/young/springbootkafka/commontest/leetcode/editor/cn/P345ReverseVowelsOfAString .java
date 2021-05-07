//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 149 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

/**
 * 反转字符串中的元音字母
 *
 * @author young
 */
class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
        // TO TEST
    }

    /**
     * 反转字符串中的元音字母
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int l = 0;   //左指针
            int r = chars.length - 1; //右指针

            //当左指针大于右指针就结束循环
            while (l < r) {
                //判断左指针是否是元音字母,不是就加
                if (isVowel(chars[l])) {
                    l++;
                    continue;
                }

                //判断右指针是否是元音字母,不是就减
                if (isVowel(chars[r])) {
                    r--;
                    continue;
                }
                //元音字母互换
                chars[l] = (char) (chars[l] + chars[r]);
                chars[r] = (char) (chars[l] - chars[r]);
                chars[l] = (char) (chars[l] - chars[r]);
                //这种是容易看懂的替换,但是内存消耗看着有点大
                // char temp = chars[l];
                // chars[l] = chars[r];
                // chars[r] = temp;
                l++;
                r--;

            }
            return String.valueOf(chars);
        }

        /**
         * @param c 用于判断的字符
         * @return 元音字母返回false 不是返回true;
         */
        private boolean isVowel(char c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    return false;
                default:
                    return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}