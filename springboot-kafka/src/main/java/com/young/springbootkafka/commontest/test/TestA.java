package com.young.springbootkafka.commontest.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TestA 打印时间
 *
 * @Author yangbing
 * @Date 2020/9/9 5:29 下午
 */
public class TestA {
    public static void main(String[] args) throws ParseException {
        String dateStart = "2008-01-01";
        String dateEnd = "2009-12-31";
        printDate(dateStart, dateEnd);
    }

    private static void printDate(String dateStart, String dateEnd) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        long startTime = date.parse(dateStart).getTime();
        long endTime = date.parse(dateEnd).getTime();
        long day = 1000 * 60 * 60 * 24;
        long days = (endTime - startTime) / day;
        for (long i = startTime; i <= endTime; i += day) {
            System.out.println(date.format(new Date(i)));
        }
    }
}
