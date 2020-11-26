### 解题思路
正常情况：二十六进制的范围是 0-25 ，所以除以 26 可以把 末尾元素 去掉，
但这道题的范围是 1-26 即位上元素是A~Z，不存在0！
为了转成我们熟悉的进制运算，我们需要把原本的数值减一进行运算
	这样原本的26减成了25，也就是Z('A'+25)，
	1减成了0,存入了A('A'+0)

### 代码

```java
class Solution {
    public String convertToTitle(int n) {
		StringBuilder stringBuilder = new StringBuilder();
	    while (n != 0) {
		    n--; 
		    stringBuilder.append((char) ('A' + n % 26));
		    n /= 26;
	    }
	    return stringBuilder.reverse().toString();
    }
}
```