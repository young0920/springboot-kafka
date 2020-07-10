package com.young.springbootkafka.commontest.langtext;

import org.apache.commons.collections.*;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bag.TreeBag;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class collectionsDemo {
    /**
     * CollectionUtils工具类的常用方法
     *　　例1: 判断集合是否为空:
     * 　　CollectionUtils.isEmpty(null): true
     * 　　CollectionUtils.isEmpty(new ArrayList()): true　　
     * 　　CollectionUtils.isEmpty({a,b}): false
     *
     * 　　例2: 判断集合是否不为空:
     * 　　CollectionUtils.isNotEmpty(null): false
     * 　　CollectionUtils.isNotEmpty(new ArrayList()): false
     * 　　CollectionUtils.isNotEmpty({a,b}): true
     *
     */
    public void collectionsUtils(){
        String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
        String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //2个数组取并集  union [A, B, C, D, E, F, G, H, K]
        System.out.println(ArrayUtils.toString(CollectionUtils.union(listA,listB)));
        //交集  intersection [B, D, F]
        System.out.println(ArrayUtils.toString(CollectionUtils.intersection(listA,listB)));
        //交集的补集 disjunction [A, C, E, G, H, K]
        System.out.println(ArrayUtils.toString(CollectionUtils.disjunction(listA,listB)));
        //差集 subtract [A, C, E]
        System.out.println(ArrayUtils.toString(CollectionUtils.subtract(listA,listB)));
        //KEY 取Value
        BidiMap bidiMap=new TreeBidiMap();
        bidiMap.put("SH","SHANGHAI");
        bidiMap.put("CD","CHENGDU");
        bidiMap.put("BJ","CHENGDUU");
        bidiMap.put("SH","CHANG");
        System.out.println(bidiMap.toString());
        System.out.println("KEY-VALUE:BJ  "+bidiMap.get("SH"));
        // 构造Map<String,Collection>
        MultiMap multiMap=new MultiValueMap();
        multiMap.put("SH","SHANGHAI");
        multiMap.put("CD","CHENGDU");
        multiMap.put("BJ","CHENGDU");
        multiMap.put("SH","CHANG");
        System.out.println(multiMap.toString());
        System.out.println("key:SH: "+multiMap.get("SH"));
        //得到集合里按顺序库存放的key之后的某一key
        OrderedMap map=new LinkedMap();
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        System.out.println(map.firstKey());
        System.out.println(map.nextKey("one"));
        System.out.println(map.nextKey("three"));
        System.out.println(map.lastKey());
        //map 迭代
        IterableMap iterableMap=new HashedMap();
        iterableMap.put("one","1");
        iterableMap.put("two","2");
        iterableMap.put("three","3");
        MapIterator it=iterableMap.mapIterator();
        while(it.hasNext()){
            Object key=it.next();
            Object value=it.getValue();
            System.out.println(key+"  "+value);
        }
        //无序的包
        System.out.println("无序的包");
        Bag bag=new HashBag();
        bag.add("a");
        bag.add("b",5);
        bag.remove("b",3);
        bag.add("c");
        bag.add("d");
        Iterator<String> ite=bag.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
        //有序的包
        System.out.println("有序的包");
        Bag bagyx=new TreeBag();
        bagyx.add("a");
        bagyx.add("b",5);
        bagyx.remove("b",3);
        bagyx.add("c");
        bagyx.add("d");
        Iterator<String> ityx=bagyx.iterator();
        while(ityx.hasNext()){
            System.out.println(ityx.next());
        }
    }


    public static void main(String[] args) {
        collectionsDemo cd=new collectionsDemo();
        cd.collectionsUtils();
    }
}
