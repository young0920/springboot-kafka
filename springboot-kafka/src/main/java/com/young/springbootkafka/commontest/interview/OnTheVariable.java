package com.young.springbootkafka.commontest.interview;

/**
 * OnTheVariable
 *
 * @Author young
 * @Date 2021/7/5
 */
public class OnTheVariable {
    public static void main(String[] args) {
        int i = 1;
        i = i++; //把i的值压入操作数栈  剧本变量表 i=2  操作数栈的值赋值
        int j = i++;
        int k = i + ++i * i++; //  ++i  局部变量表 i自增等于三，压入操作数栈
        System.out.println(i);//4
        System.out.println(j);//1
        System.out.println(k);//11
    }
}
