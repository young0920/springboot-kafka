package com.young.springbootkafka.commontest.utiltest;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TestC
 *
 * @Author yangbing
 * @Date 2020/9/21 2:08 下午
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        System.out.println(Arrays.toString(nums));
        // write your code here
        if (nums.length <= 0) {
            return 0;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        nums = set.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums));
        return set.size();
    }
}
