package com.young.springbootkafka.commontest.utiltest;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据resultMap生成相应别名
 *
 * @Author yangbing
 * @Date 2020/9/18 2:48 下午
 */
public class GenerateAliases {
    public static void main(String[] args) {
        String s = "\t\t<result property=\"createBy\" column=\"CREATE_BY_\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"createTime\" column=\"CREATE_TIME_\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"constructionPeriod\" column=\"F_CONSTRUCTION_PERIOD\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"endStation\" column=\"F_END_STATION\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineColorId\" column=\"F_LINE_COLOR_ID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineInvestment\" column=\"F_LINE_INVESTMENT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"lineLength\" column=\"F_LINE_LENGTH\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"lineMark\" column=\"F_LINE_MARK\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineName\" column=\"F_LINE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineStatioan\" column=\"F_LINE_STATIOAN\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"startEndStatioan\" column=\"F_START_END_STATIOAN\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"startStation\" column=\"F_START_STATION\" jdbcType=\"VARCHAR\"/>";
        getColoum(s,"detail");
    }

    private static void getColoum(String str,String per){
        String[] lineArray = str.split("\n");
        List<String> coloumAs = new ArrayList<>();
        for (String eachLine : lineArray) {
            String[] splits = eachLine.split("\"");
            StringBuilder sbb = new StringBuilder();
            sbb.append(per).append(".").append(splits[3]).append(" as ").append(per+ "_" +splits[1]).append(",");
            coloumAs.add(sbb.toString());
            splits[3] = per+ "_" +splits[1];
            StringBuilder sb = new StringBuilder();
            for (String s1 : splits) {
                sb.append(s1).append("\"");
            }
            String substring = sb.substring(0, sb.length() - 1);
            System.out.println(substring);
        }
        coloumAs.forEach(s -> System.out.println(s));
    }
}
