package com.young.springbootkafka.commontest.lambdatest;

import static java.lang.System.out;

public class PersonTest {
    public static void main(String[] args) {
        Person p=()-> out.println("Hello world !");
        p.eat();
    }
}
