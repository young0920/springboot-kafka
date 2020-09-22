package com.young.springbootkafka.commontest.langtext;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class langtextdemo {
    /**
     * 查找嵌套字符串
     * @param str
     * @return
     */
    public static String subBetween(String str){
        String result=StringUtils.substringBetween(str,"a","a");
        return result;
    }

    /**
     * StringUtils.abbreviate(str,width);
     * StringUtils.abbreviate(str,offset，width);
     * 在给定的width内取得str的缩写,当testString的长度小于width则返回原字符串.
     * 注意：width参数至少为4（包括…）
     * @param str
     * @return
     */
    public static  String abbre(String str){
        String result=StringUtils.abbreviate(str,5,15);
        return result;
    }

    /**
     * 重复字符串
     */
    public  void repeatStr(){
        System.out.println( StringUtils.repeat( "*", 40));
        System.out.println( StringUtils.center("center",40,"*"));

    }

    /**
     * 首字母大小写
     * @param str
     * @return
     */
    public static String upperAndLower(String str){
        //首字母大写
        String result=StringUtils.capitalize(str);
        //首字母小写
        //  String result=StringUtils.capitalize(str)；
        return result;
    }

    /**
     * 大小写转换
     * @param str
     * @return
     */
    public static String swapCase(String str){
        String result=StringUtils.swapCase(str);
        return result;
    }

    /**
     * value取key——BidiMap
     */
    public void valueKey(){
        BidiMap bidiMap=new DualHashBidiMap();
        bidiMap.put("SH","SHANGHAI");
        bidiMap.put("CD","CHENGDU");
        bidiMap.put("BJ","CHENGDU");
        bidiMap.put("SH","CHANGZHOU");
        System.out.println("KEY-VALUE:BJ  "+bidiMap.get("SH"));
        System.out.println("VALUE-KEY:CHENGDU  "+bidiMap.getKey("CHENGDU"));
    }


    /**
     * 数组转Map
     */
    public void arrayToMap(){
        Map colorMap = ArrayUtils.toMap(new String[][] {
                {"RED", "#FF0000"},
                {"GREEN", "#00FF00"},
                {"BLUE", "#0000FF"}
        });
        System.out.println(colorMap.toString());
    }

    /**
     * ArrayUtils 常用
     */
    public void arrays(){
        System.out.println( StringUtils.center("ArrayUtils",40,"*"));
        //不定参数转数组
        String[] array = ArrayUtils.toArray("1", "2");
        System.out.println(ArrayUtils.toString(array));
        //转空数组
        String[] emptyArray = ArrayUtils.<String>toArray();
        System.out.println(ArrayUtils.toString(emptyArray));
        //截取子数组
        Object[] s1=ArrayUtils.subarray(new Object[]{"aa","bb","cc"},1,2);
        System.out.println(ArrayUtils.toString(s1));
        ArrayUtils.swap(new String[]{"1", "2", "3"}, 0,2); //["3", "2", "1"]
        //将单个元素合并到指定索引位置的数组中
        //ArrayUtils.add(new String[]{"a"},0,"b"); //["b", "a"]
        //移除数组中第一个元素
        ArrayUtils.removeElement(new String[]{"a", "b"}, "a");

    }

    /**
     * 日期时间工具类
     * DateFormatUtils&FastDateFormat
     * 提供了日期的格式化操作    线程安全
     */
    public void dateUtilsMethods() throws ParseException {
        System.out.println( StringUtils.center("日期时间",40,"*"));
        //格式化Date对象
        String date1= DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        System.out.println(date1);
        //格式化Calendar对象
        String date2= DateFormatUtils.format(Calendar.getInstance(),"yyyy-MM-dd'T'HH:mm:ssZZ");
        System.out.println(date2);
        //格式化TimelnMills
        String date3= DateFormatUtils.format(Calendar.getInstance().getTimeInMillis(),"yyyy MMM dd EEE HH:mm:ss");
        System.out.println(date3);
        System.out.println(DateUtils.isSameDay(new Date(),new Date()));
        //解析日期时间字符串日期时间Date对象，通过尝试各种不同的解析器来解析表示日期的字符串
        System.out.println(DateUtils.parseDate("2017年06月03日 23时51分44秒", "yyyy-MM-dd HH:mm:ss", "yyyy年MM月dd日 HH时mm分ss秒"));

    }
    public static void main(String[] args) throws ParseException {
        langtextdemo lt=new langtextdemo();
        String str="abcdefg a hijkLMN a opQrst";
        System.out.println(subBetween(str));
        System.out.println(abbre(str));
        lt.repeatStr();
        System.out.println(upperAndLower(str));
        System.out.println(swapCase(str));
        lt.valueKey();
        lt.arrayToMap();

        lt.arrays();

        lt.dateUtilsMethods();

    }
}
