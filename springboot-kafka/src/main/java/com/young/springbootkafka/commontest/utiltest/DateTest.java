package com.young.springbootkafka.commontest.utiltest;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TestA 打印时间
 *
 * @Author yangbing
 * @Date 2020/9/9 5:29 下午
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String dateStart = "2008-01-01";
        String dateEnd = "2009-12-31";
        printDate(dateStart, dateEnd);
    }

    private static void printDate(String dateStart, String dateEnd) throws ParseException {
        //        DateFormatUtils.format()
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        String format1 = DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");
        String format2 = DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd");
        long startTime = date.parse(dateStart).getTime();
        long endTime = date.parse(dateEnd).getTime();
        long day = 1000 * 60 * 60 * 24;
        long days = (endTime - startTime) / day;
        for (long i = startTime; i <= endTime; i += day) {
            System.out.println(date.format(new Date(i)));
        }
    }
}
