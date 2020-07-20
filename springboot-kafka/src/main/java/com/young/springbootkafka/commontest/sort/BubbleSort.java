package com.young.springbootkafka.commontest.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/20 20:00
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        int[] arr1 = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        bubbleSort(arr);
        bubbleSortPlus(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    private static void bubbleSort(int[] arr) {
        //第一层for循环,用来控制冒泡的次数
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                //第二层for循环,用来控制冒泡一层层到最后
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    //如果前一个数比后一个数大,两者调换 ,意味着泡泡向上走了一层
                    if (arr[j + 1] < arr[j]) {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void bubbleSortPlus(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                // 初始化一个布尔值
                boolean flag = true;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 调换
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }
}
