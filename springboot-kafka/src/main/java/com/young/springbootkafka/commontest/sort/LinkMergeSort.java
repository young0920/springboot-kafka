package com.young.springbootkafka.commontest.sort;


import com.young.springbootkafka.pojo.ListNode;

/**
 * 链表归并排序
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/21 18:39
 */
public class LinkMergeSort {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(1);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        head = mergeSort(head);

        while (head.next != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println(head.val);
    }


    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //获取链表中间节点
        ListNode mid = getMid(head);

        //把链表从之间拆分为两个链表：head和second两个子链表
        ListNode midNext = mid.next;
        mid.next = null;

        //对两个子链表排序
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(midNext);

        return merge(right, left);
    }

    /**
     * 两个有序链表的归并
     *
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {
        //辅助节点，排好序的节点将会链接到dummy后面
        ListNode dummy = new ListNode(0);

        //tail指向最后一个排好序的节点
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            //移动tail指针
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;

    }

    /**
     * 返回链表之间节点
     *
     * @param head
     * @return
     */
    private static ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode faster = head.next;
        //快2步，慢一步
        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }
        return slow;
    }
}
