package com.young.springbootkafka.commontest.utiltest;

/**
 * SwitchCse
 *
 * @author yangbing
 * @date 2021/4/26 下午2:17
 */
public class SwitchCse {
    public static void main(String[] args) {
        System.out.println(method(1));
        System.out.println(method(4));
        System.out.println(method(5));
    }

    private static int method(int n) {
        switch (n) {
            case 1:
            case 2:
            case 3:
                n += 3;
                break;
            case 4:
                n += 4;
                break;
            default:
                n += 5;
                break;
        }
        return n;
    }
}
