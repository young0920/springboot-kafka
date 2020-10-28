package com.young.springbootkafka.pojo;

/**
 * 单链表
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/21 19:37
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append(this.val);
        if (this.next != null) {
            ListNode n = this.next;
            while (true) {
                sb.append("->").append(n.val);
                //没下一个了
                if (n.next == null){
                    break;
                }
                //有下一个
                n = n.next;
            }
        }
        return sb.toString();
    }
}
