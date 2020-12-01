//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 243 👎 0


package com.young.springbootkafka.commontest.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author young
 */
class P225ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new P225ImplementStackUsingQueues().new MyStack();
        // TO TEST
    }

    /**
     * 用队列实现栈
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {


        private Queue<Integer> qu1;
        private Queue<Integer> qu2;
        public int usedSize;


        /**
         * Initialize your data structure here.
         */
        //构造方法
        public MyStack() {
            qu1 = new LinkedList<>();
            qu2 = new LinkedList<>();

        }

        /**
         * Push element x onto stack.
         */
        //入队
        public void push(int x) {
            //1、谁不为空  入到哪个队列就好了
            //2、两个都为空   放到第一个qu1当中
            if (!qu1.isEmpty()) {
                qu1.offer(x);
            } else if (!qu2.isEmpty()) {
                qu2.offer(x);
            } else {
                qu1.offer(x);
            }
            usedSize++;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        //出队
        public int pop() {
            //1.先将前面size-1个移动到空的队列
            //2.将队列最后一个弹出，就是类似于出栈顺序
            //3.反复进行，直到俩个队列都为空的时候出队完毕
            if (empty()) {//俩个队列都空
                return -1;
            }
            int size = usedSize;
            if (!qu1.isEmpty()) {
                for (int i = 0; i < size - 1; i++) {
                    qu2.offer(qu1.poll());
                }
                usedSize--;
                return qu1.poll();
            } else {

                for (int i = 0; i < size - 1; i++) {
                    qu1.offer(qu2.poll());
                }
                usedSize--;
                return qu2.poll();
            }

        }

        /**
         * Get the top element.
         */
        //弹栈顶
        public int top() {
            if (empty()) {//俩个队列都空
                return -1;
            }
            int tmp = -1;
            int size = usedSize;
            if (!qu1.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    tmp = qu1.poll();
                    qu2.offer(tmp);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    tmp = qu2.poll();
                    qu1.offer(tmp);
                }
            }
            return tmp;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if (qu1.isEmpty() && qu2.isEmpty()) {
                return true;
            }
            return false;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}