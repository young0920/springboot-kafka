package com.young.springbootkafka.commontest.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/20 20:25
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (arr != null && arr.length > 1 && low < high) {
            int mid = (low + high) / 2;
            //对左边序列进行归并排序
            mergeSort(arr, low, mid, tmp);
            //对右边序列进行归并排序
            mergeSort(arr, mid + 1, high, tmp);
            //合并两个有序序列
            merge(arr, low, mid, high, tmp);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        //左边序列和右边序列起始索引
        int j = low;
        int k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }

        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }

}
