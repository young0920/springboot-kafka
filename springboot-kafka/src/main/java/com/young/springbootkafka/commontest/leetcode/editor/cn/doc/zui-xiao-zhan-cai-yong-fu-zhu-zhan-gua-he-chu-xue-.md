### 解题思路
/*
stack是你的栈，旁边弄一个放最小值的辅助栈minStack
1.每次入栈的元素（x）都和最小栈的栈顶元素进行比较
2.当x <= minStack.pop();//栈顶元素
3.则将x同时也加入到minStack中

4.出栈的时候的元素（x），将x和minStack.pop();（栈顶元素）比较，如果x = minStack.pop();
5.则将minStack.pop()同时也弹出;
*/
### 代码

```java
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    //入栈
    public void push(int x) {
        //1、stack是一定需要放元素的
        //2、最小栈当中 是否存放数据   x<= 最小栈的栈顶元素
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);}
        else if(x <= minStack.peek()){
            minStack.push(x);
        }
    }
    //出栈
    public void pop() {
        //1、stack是一定需要弹出元素的
        //2、最小栈当中 是否弹出数据    x  ==  最小栈的栈顶元素
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        //跟最小栈没有关系
       return stack.peek();
    }
    
    public int getMin() {
        //每次返回最小栈的栈顶元素
        return minStack.peek();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```