package com.young.springbootkafka.commontest.sort;

import org.apache.commons.lang3.ArrayUtils;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/21 16:19
 */
public class ArraysSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        String[] str = {"张", "张三", "张三三",};
        String[] str1 = {"李三","阿三", "王三", "杨三"};

        //默认升序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //基本类型不能降序  需要装箱
        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr1));

        //默认安装长度排序
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, Collections.reverseOrder());
        System.out.println(Arrays.toString(str));

        //中文首字母升序  输出结果数字排在最前，英文字母其次，汉字则按照拼音进行排序。
        Arrays.sort(str1, Collator.getInstance(Locale.CHINA));
        System.out.println(Arrays.toString(str1));

        //中文降序
        ArrayUtils.reverse(str1);
        System.out.println(Arrays.toString(str1));


    }
}
