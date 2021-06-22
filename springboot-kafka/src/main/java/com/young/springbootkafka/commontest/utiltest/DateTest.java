package com.young.springbootkafka.commontest.utiltest;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
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

        //是否为数字
        System.out.println(NumberUtils.isCreatable("2"));
        //是否全数字
        System.out.println(NumberUtils.isDigits("2"));


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        String format = df.format(date);
        System.out.println(format);
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
