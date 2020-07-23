package com.young.springbootkafka.commontest.stream;

import java.util.stream.Stream;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/22 17:28
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));
    }

}
