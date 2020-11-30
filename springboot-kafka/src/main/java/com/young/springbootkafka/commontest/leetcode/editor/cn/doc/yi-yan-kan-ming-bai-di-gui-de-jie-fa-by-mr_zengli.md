### 解题思路
重点说一下递归时的理解:

自己的理解:
假设: (1->2)-(2->3)-(3->4)-(4->5)-(5->null)
递归情况下直接到最后一个节点:(5->null)
  反转之后是:节点5指向节点4, (5 -> 4) ,但是实际节点4又指向的5,所以,必须将节点4的next 设置为null(避免循环链表)
  依次向上:
  0. (1->2)-(2->3)-(3->4)-(4->5)-(5->null)
  1. (1->2)-(2->3)-(3->4)-(4->null)-(5->4)
  2. (1->2)-(2->3)-(3->null)-(4->3)-(5->4)
  3. (1->2)-(2->null)-(3->2)-(4->3)-(5->4)
  4. (1->null)-(2->1)-(3->2)-(4->3)-(5->4)
  5. 递归完成返回
  一眼就能看出,这里其实就是单向链表的末尾的next元素,不停的与前一个元素的val替换的过程

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
         if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
```