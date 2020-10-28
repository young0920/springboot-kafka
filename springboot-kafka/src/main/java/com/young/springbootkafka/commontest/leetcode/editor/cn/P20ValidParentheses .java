//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1941 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author young
 */
class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.isValid("()[]{}"));
    }

    /**
     * 有效的括号
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.empty()) {
                        return false;
                    }
                    char peek = stack.pop();
                    if (peek == ')' || peek == ']' || peek == '}') {
                        return false;
                    }
                    if (c == ')') {
                        if (peek != '(') {
                            return false;
                        }
                    } else if (c == ']') {
                        if (peek != '[') {
                            return false;
                        }
                    } else {
                        if (peek != '{') {
                            return false;
                        }
                    }
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}