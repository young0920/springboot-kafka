package com.young.springbootkafka.commontest.commontest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangbing
 * @date 2018/12/28
 */
public class CommonTest {
    /**
     * 实现数组元素的翻转
     * @param arr
     * @return
     */
    public static int[] reverse(int[] arr) {
        // 遍历数组
        for (int i = 0; i < arr.length / 2; i++) {
            // 交换元素
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }
        // 返回反转后的结果
        return arr;
    }

    public void  mathMethed(){
        /**
         * Math.sqrt() : 计算平方根
         * Math.cbrt() : 计算立方根
         * Math.pow(a, b) : 计算a的b次方
         * Math.max( , ) : 计算最大值
         * Math.min( , ) : 计算最小值
         * Math.abs() : 取绝对值
         * Math.ceil(): 天花板的意思，就是逢余进一
         * Math.floor() : 地板的意思，就是逢余舍一
         * Math.rint(): 四舍五入，返回double值。注意.5的时候会取偶数
         * Math.round(): 四舍五入，float时返回int值，double时返回long值L
         *
         */
    }


    /**
     * 数组  List 互转
     */
    public void arrayToList() {
        int[] data = {4, 5, 3, 6, 2, 5, 1};

        // int[] 转 List<Integer>
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());


        // int[] 转 Integer[]
        // 前两步同上，此时是Stream<Integer>。
        // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
        // 这样就可以返回Integer数组。
        // 不然默认是Object[]。
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);


        // List<Integer> 转 Integer[]
        //  调用toArray。传入参数T[] a。这种用法是目前推荐的。
        // List<String>转String[]也同理。
        Integer[] integers2 = list1.toArray(new Integer[0]);


        // List<Integer> 转 int[]
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。
        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();


        // Integer[] 转 int[]
        // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。
        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();


        // Integer[] 转 List<Integer>
        // 最简单的方式。String[]转List<String>也同理。
        List<Integer> list2 = Arrays.asList(integers1);


        // 同理
        String[] strings1 = {"a", "b", "c"};
        // String[] 转 List<String>
        List<String> list3 = Arrays.asList(strings1);
        // List<String> 转 String[]
        String[] strings2 = list3.toArray(new String[0]);

        String str = "";
        char[] chars = str.toCharArray();
    }

    /**
     * 数组
     * 数组，及时有序的想同类型元素序列，数组一旦定义后，长度就不会发生改变
     * 数组的定义方式：
     * 第一种：数据类型[] 变量名 = new 数据类型[长度];
     * 第二种：数据类型[] 变量名名 = {元素，元素，元素};
     * 第三种：数据类型[] 变量名 = new 数据类型[]{元素，元素...};
     */
    public void createArray() {

        //第一种：数据类型[] 变量名 = new 数据类型[长度];
        int[] arrayOne = new int[10];
        //第二种：数据类型[] 变量名名 = {元素，元素，元素};
        int[] arrayTwo = {1, 2, 4, 8, 9};
        //第三种：数据类型[] 变量名 = new 数据类型[]{元素，元素...};
        int[] arrayThree = new int[]{4, 8, 7, 6};

        int[][] arrOne = new int[5][3];
        int[][] arrTwo = {{22, 15, 32, 20, 18}, {12, 21, 25, 19, 33}, {14, 58, 34, 24, 66}, {33, 22}};
        //一维数组打印
        System.out.println(Arrays.toString(arrayTwo));
        //二维数组打印
        System.out.println(Arrays.deepToString(arrTwo));
    }

/*    1.使用ArrayUtils比较数组长度是否相等
    例如：比较array1和array2的长度
    String[] array1 = { "123", "321" };
    String[] array2 = { "123" };*/

    public void lengthCompare() {
        String[] array1 = {"123", "321"};
        String[] array2 = {"123"};
        System.out.println(array1.length == array2.length);
    }
/*2.将数组内容逆序输出
    例如：
    String[] array1 = { "123", "321" };
    逆序输出：321，123*/

    public void arrayReverse() {
        String[] array1 = {"123", "321"};
        ArrayUtils.reverse(array1);
        System.out.println(Arrays.toString(array1));
    }

/*     3.判断数组中是否包含某个元素
    例如：String[] array1 = { "123", "321" };中是否包含123*/

    public void containsElement() {
        String[] array1 = {"123", "321"};
        System.out.println(ArrayUtils.contains(array1, "123"));
    }

/*4.判断某一元素在数组中最后出现的位置
    例如：String[] array1 = { "123", "321", "123" };中123最好出现的位置*/

    public void lastIndex() {
        String[] array1 = {"123", "321", "123"};
        System.out.println(ArrayUtils.lastIndexOf(array1, "123"));
    }

/*5.将连个数组拼成一个数组
    例如： Integer[] array1 = { 123 };Integer[] array2 = { 456 };将array1和array2拼成array3.*/

    public void addAll() {
        Integer[] array1 = {123};
        Integer[] array2 = {456};
        Integer[] array3 = ArrayUtils.addAll(array1, array2);
        System.out.println(Arrays.toString(array3));
    }

/*6.删除某一数组中的元素
    例如：Integer[] array1 = { 123, 456, 789 };中将123删除*/

    public void removeElement() {
        Integer[] array1 = {123, 456, 789};
        System.out.println(Arrays.toString(ArrayUtils.removeElement(array1, 123)));
    }

/*7.获取最大值，最小值
    例如： int a = 123; int b = 234; int c = 456;求出三个值得最大和最小*/

    public void getMaxAndMin() {
        int a = 123;
        int b = 234;
        int c = 456;
        int[] array = {123, 456, 789};
        System.out.println(NumberUtils.max(array));
        System.out.println(NumberUtils.max(a, b, c) + "," + NumberUtils.min(a, b, c));

    }

/*8.判断某一字符串是否是数字
    例如：String str = "123456";String str1 = "123456a";这两字符串是否是数字*/

    public void number() {
        String str = "123456";
        String str1 = "123456a";
        System.out.println("str:" + StringUtils.isNumeric(str));
        System.out.println("str1:" + StringUtils.isNumeric(str1));
    }

/*9.截取字符串最后三位数
    例如：String str = "12adsf1a3sd1fa3sdf";最后三位数为sdf*/

    public void substringNumber() {
        String str = "12adsf1a3sd1fa3sdf";
        System.out.println(StringUtils.substring(str, str.length() - 3));
    }

/*10.去除多余空格
    例如：String str = "  asdfhasd12231  ";将字符串中的头尾空格去除*/

    public void trim() {
        String str = "  asdfhasd12231  ";
        System.out.println(StringUtils.trim(str));
    }
/*
11.判断字符串中是否存在包含关系
    例如： String str = "asdfhasd12231";String str1="123"；str中是否包含str1*/

    public void contains() {
        String str = "asdfhasd12231";
        String str1 = "123";
        System.out.println(StringUtils.contains(str, str1));
    }
/*
12.重复输出100个字符串
    例如： String str = "*@*";将str输出100次*/

    public void outString() {
        String str = "*@*";
        System.out.println(StringUtils.repeat(str, 100));
    }
/*13.将字母转成大写输出
    例如：String str = "asd";将str转成ASD输出*/

    public void upperCase() {
        String str = "asd";
        System.out.println(StringUtils.upperCase(str));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CommonTest ct = new CommonTest();
        ct.lengthCompare();//1.false
        ct.arrayReverse();//2.[321, 123]
        ct.containsElement();//3.true
        ct.lastIndex();//4.2
        ct.addAll();//5.[123, 456]
        ct.removeElement();//6.[456, 789]
        ct.getMaxAndMin();//7. 456,123
        ct.number();//8. str:true str1:false
        ct.substringNumber();//9.sdf
        ct.trim();//10, asdfhasd12231
        ct.contains();//11. false
        ct.outString();//12
        ct.upperCase();//13.ASD
        ct.createArray();
    }
}
