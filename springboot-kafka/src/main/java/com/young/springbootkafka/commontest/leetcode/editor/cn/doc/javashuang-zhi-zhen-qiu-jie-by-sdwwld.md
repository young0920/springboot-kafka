##### 1，因为数组是排序的，所以双指针求解是最简单的一种方式，代码如下
```
    public int[] twoSum(int[] num, int target) {
        int left = 0, right = num.length - 1;
        while (left < right) {
            int mid = num[left] + num[right];
            if (mid == target) {
                return new int[]{left + 1, right + 1};
            } else if (mid > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0, 0};
    }
```
###### 2，我们还可以把数组的元素存储到Map中，然后再查找
```
    public int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>(num.length);
        for (int i = 0; i < num.length; i++) {
            if (map.get(target - num[i]) != null) {
                return new int[]{map.get(target - num[i]) + 1, i + 1};
            }
            map.put(num[i], i);
        }
        return new int[]{0, 0};
    }
```
##### 3,二分法查找
```
    public int[] twoSum(int[] num, int target) {
        int length = num.length;
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;
            int val = target - num[i];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (num[mid] == val)
                    return new int[]{i + 1, mid + 1};
                else if (num[mid] < val)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return new int[]{0, 0};
    }
```

##### 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”