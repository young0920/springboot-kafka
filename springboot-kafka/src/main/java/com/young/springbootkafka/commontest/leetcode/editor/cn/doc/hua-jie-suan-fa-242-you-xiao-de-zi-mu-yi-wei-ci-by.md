### 解题思路

- 标签：哈希映射
- 首先判断两个字符串长度是否相等，不相等则直接返回 false
- 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
- s 负责在对应位置增加，t 负责在对应位置减少
- 如果哈希表的值都为 0，则二者是字母异位词

### 代码

```Java []
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }
}
```

### 画解


 ![frame_00001.png](https://pic.leetcode-cn.com/f52b9bdf8920058f3194706b2f9c7fce1cbcc31842e1a5662e67d3a879afbafa-frame_00001.png) ![frame_00002.png](https://pic.leetcode-cn.com/72de54cca80efa6b315fd49f0feef6b83ed45e82632d049c5c87de2bd74ad4b6-frame_00002.png) ![frame_00003.png](https://pic.leetcode-cn.com/a3cc5ecb1cda081397629fe7d3f541a72f4d727d9aa4676727a2d9dc8d453741-frame_00003.png) ![frame_00004.png](https://pic.leetcode-cn.com/96ff8c4d97bef9b67465687f01e571a42d755b2b70fa7a55b45ba01d60c43d0c-frame_00004.png) ![frame_00005.png](https://pic.leetcode-cn.com/59549c119a1bc3f0c03704f519b2be8bcce308cba867c07c5080a8cf58b8791f-frame_00005.png) ![frame_00006.png](https://pic.leetcode-cn.com/47bdf23d8e6fafec8b18cce95ff7346adc8cb52c72de99913a589c1171336f83-frame_00006.png) ![frame_00007.png](https://pic.leetcode-cn.com/ef2be2684acee5968d017eff7e15f369fb1fb2aa8bb5a5b6dc2fe89bc5ca6a49-frame_00007.png) ![frame_00008.png](https://pic.leetcode-cn.com/95f33715f7edfd19639c4f4883f1c76d6335a347eb7630c50d063ff171462adb-frame_00008.png) ![frame_00009.png](https://pic.leetcode-cn.com/3c66f04cc04a119258e7ed467a0dd8fdf25a1a2b753e4ac0b3854f469a8906ad-frame_00009.png) ![frame_00010.png](https://pic.leetcode-cn.com/61d7240f67d04390a38725dbccac0b289f565a141f4378506678e7abea08993e-frame_00010.png) 

想看大鹏画解更多高频面试题，欢迎阅读大鹏的 LeetBook：[《画解剑指 Offer 》](https://leetcode-cn.com/leetbook/detail/illustrate-lcof/)，O(∩_∩)O