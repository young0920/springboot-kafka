### 解题思路


### 代码

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        int left=0,right=num;
        while(left<=right){
            int mid=(left+right)/2;
            if((long)mid*mid==num){
                return true;
            }else if((long)mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}
```