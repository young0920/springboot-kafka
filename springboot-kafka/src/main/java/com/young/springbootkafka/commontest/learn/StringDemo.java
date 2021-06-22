package com.young.springbootkafka.commontest.learn;

/**
 * StringDemo
 *
 * @Author young
 * @Date 2021/5/13
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }
}
