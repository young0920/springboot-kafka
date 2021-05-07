### 解题思路
看代码
### 代码

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int index = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        //这里length1,length2都可以
        int[] res = new int[length1];
        //当有一个到头之后,就可退出循环
        while(i < length1 && j < length2){
            if(nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                res[index++] = nums1[i];
                i++;
                j++; 
            }
        }   
        return Arrays.copyOfRange(res,0,index);
    }
}
```