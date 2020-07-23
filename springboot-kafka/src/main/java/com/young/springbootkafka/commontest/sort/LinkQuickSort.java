package com.young.springbootkafka.commontest.sort;


import com.young.springbootkafka.pojo.ListNode;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/21 18:39
 */
public class LinkQuickSort {
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

        quickSort(head, null);

        while (head.next != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
        System.out.println(head.val);
    }


    public static void quickSort(ListNode begin, ListNode end) {
        if (begin == null || begin == end) {
            return;
        }
        ListNode index = getIndex(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);
    }

    /**
     * 划分函数，以头结点值为基准元素进行划分
     *
     * @param begin
     * @param end
     * @return
     */
    public static ListNode getIndex(ListNode begin, ListNode end) {
        if (begin == null || begin == end) {
            return begin;
        }

        //基准元素
        int val = begin.val;
        ListNode index = begin;
        ListNode next = begin.next;

        while (next != end) {
            if (next.val < val) {
                //交换
                index = index.next;
                int tmp = next.val;
                next.val = index.val;
                index.val = tmp;
            }
            next = next.next;
        }

        begin.val = index.val;
        index.val = val;

        return index;
    }
}
