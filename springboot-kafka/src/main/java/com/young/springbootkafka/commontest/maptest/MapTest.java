package com.young.springbootkafka.commontest.maptest;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map
                = new LinkedHashMap<String,Integer>();
        map.put("语文", 98);
        map.put("数学", 97);
        map.put("英语", 96);
        map.put("物理", 95);
        map.put("化学", 98);
        System.out.println(map);

        /*
         * 遍历所有的key
         * Set<K> keySet()
         * 将当前Map中所有的key以一个Set集合
         * 形式返回。遍历这个集合就等同于遍历
         * 了所有的key
         */
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            System.out.println("key:"+key);
        }

        /*
         * 遍历每一组键值对
         * Set<Entry> entrySet()
         *
         * java.util.Map.Entry
         * Entry的每一个实例用于表示当前Map中的
         * 一组键值对。其中有两个常用的方法:
         * getKey(),getValue()分别用于获取对应的
         * key与value
         */

        Set<Map.Entry<String,Integer>> entrySet
                = map.entrySet();

        for(Map.Entry<String, Integer> e: entrySet) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+":"+value);
        }

        /*
         * 遍历所有的value
         */
        Collection<Integer> values = map.values();
        for(Integer value : values) {
            System.out.println("value:"+value);
        }
    }
}
