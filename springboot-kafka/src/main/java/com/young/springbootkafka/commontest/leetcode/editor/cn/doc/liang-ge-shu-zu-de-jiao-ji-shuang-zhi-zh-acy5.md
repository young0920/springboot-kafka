# 解题思路
**双指针：i 指针指向 nums1 数组中的开头；j 指针指向 nums2 数组中的开头。**

首先，先将两个数组从小到大进行排序，然后定义 HashSet 集合来对两个数组的交集进行存储，**Set 集合有去重的功能，这样即便是两个数组中相同的元素有多个，在 Set 集合中也只会存储一个。**

**i、j 指针分别遍历 nums1 和 nums2 数组：**

- **`若 nums1[i] == nums2[j]`**，则找到了两个数组中的交集中的一个，将 nums1[i] 添加到 Set 集合中，然后令 i 指针和 j 指针分别后移。

- **`若 nums1[i] < nums2[j]`**，因为此时两个数组均为从小到大排序的数组，此时 i 指针指向的元素 nums1[i] < j 指针指向的元素 nums2[j]，则在 j 指针指向的当前元素的后面，都不会再有元素与 nums1[i] 相等，**即 nums1[i] 不是两数组的交集**，此时只需令 i 指针后移一位即可（**因为，nums2[j] 可能还会在 nums1 中当前 i 位置的后面出现**）。
        
- **`若 nums1[i] > nums2[j]`**，则此时只需将 j 指针后移一位即可。


---
# 代码
```java
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>(); // 存储时会去重
        while (i < n && j < m) {

            if (nums1[i] == nums2[j]) {

                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) { // 谁小，谁的指针需要往后移动

                i++;
            } else {

                j++;
            }
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {

            res[index++] = num;
        }
        return res;
    }
}
```