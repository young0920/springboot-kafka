### 解题思路
使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
时间复杂度为 O(N)：只需要遍历所有元素一次
空间复杂度 O(1)：只需要使用两个额外变量

### 代码

```java
class Solution {
    private final static HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A',
         'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        // ArrayList<Character> arr = new ArrayList<>();
        // arr.add('a');
        // arr.add('e');
        // arr.add('i');
        // arr.add('o');
        // arr.add('u');
        // arr.add('A');
        // arr.add('E');
        // arr.add('I');
        // arr.add('O');
        // arr.add('U');      
        if(s==null) return null;
        int low = 0,high = s.length()-1;      
        char[] c = new char[s.length()] ;
        while(low<=high){
            char cl = s.charAt(low);
            char ch = s.charAt(high);
            if(!vowels.contains(cl)){
                c[low++] = cl;
            }else if(!vowels.contains(ch)){
                c[high--] = ch;
            }else{
                c[low++] = ch;
                c[high--] = cl;
            }   
        }
        return new String(c);
    }
}
```