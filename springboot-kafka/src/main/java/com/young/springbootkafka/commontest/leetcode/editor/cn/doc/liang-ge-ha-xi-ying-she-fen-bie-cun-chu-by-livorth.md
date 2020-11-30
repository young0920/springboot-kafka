### 解题思路
使用两个哈希映射分别存储s到t的映射与t到s的映射。
很蠢的办法，而且在我写完之后看到别人的题解，把映射的过程封装成方法，这样可以简化代码。

### 代码

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hashmap = new HashMap();
        Map<Character, Character> hashmap2 = new HashMap();

        Character c;
        for(int i = 0; i < s.length(); ++i)
        {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            if(hashmap.containsKey(cs))
            {
                if(hashmap.get(cs) != ct)
                    return false;
            }
            else
                hashmap.put(cs,ct);

            if(hashmap2.containsKey(ct))
            {
                if(hashmap2.get(ct) != cs)
                    return false;
            }
            else
                hashmap2.put(ct,cs);

            
        }
        // hashmap.clear();
        return true;
    }
}
```