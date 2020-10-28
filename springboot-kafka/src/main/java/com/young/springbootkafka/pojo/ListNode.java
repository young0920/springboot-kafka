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
}
