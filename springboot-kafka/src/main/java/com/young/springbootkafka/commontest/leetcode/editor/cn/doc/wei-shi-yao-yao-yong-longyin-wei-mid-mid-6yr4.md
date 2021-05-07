### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num / 2;
        if (num < 2) {
      return true;
    }
        while(low <= high){
            long mid = low + (high - low) / 2;
            long res = mid * mid;
            if(res == num){
                return true;
            }else if(res > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
```