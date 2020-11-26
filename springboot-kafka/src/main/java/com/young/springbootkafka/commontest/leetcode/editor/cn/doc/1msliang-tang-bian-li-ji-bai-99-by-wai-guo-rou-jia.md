### 解题思路

如果A和B有交叉的部分，那么按照尾部对齐，A和B**同步**往后遍历，那么总会走到那个交叉点。

所以现在的问题就变成了如何找到这个对齐的位置，
思路也很简单：
1. 先一趟遍历，统计A和B的长度
2. 哪个链表长，就先走几步

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        int countA = 0, countB = 0;
        while (nodeA != null) {//统计A的长度
            countA++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {//统计B的长度
            countB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        while (countA > countB) {//A比较长，A先往后走几步
            nodeA = nodeA.next;
            countA--;
        }
        while (countB > countA) {//B比较长，B先往后走几步
            nodeB = nodeB.next;
            countB--;
        }
        while (nodeA != null) {//此时A和B起点已经对齐，开始寻找共同起点
            if (nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}
```