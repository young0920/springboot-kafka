package com.young.springbootkafka.commontest.utiltest;

import org.apache.commons.lang3.StringUtils;

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
        String s = "<result property=\"proNo\" column=\"proNo\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proName\" column=\"proName\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proCompany\" column=\"proCompany\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proStartDate\" column=\"proStartDate\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proEndDate\" column=\"proEndDate\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proMoney\" column=\"proMoney\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proLastTotalmoney\" column=\"proLastTotalmoney\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proPlanMoney\" column=\"proPlanMoney\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"proInPlan\" column=\"proInPlan\" jdbcType=\"VARCHAR\"/>";
        getColoum(s,"");
    }

    private static void getColoum(String str,String per){
        String[] lineArray = str.split("\n");
        List<String> coloumAs = new ArrayList<>();
        for (String eachLine : lineArray) {
            String[] splits = eachLine.split("\"");
            StringBuilder sbb = new StringBuilder();
            sbb.append(StringUtils.isNotBlank(per) ? per + "." : "").append(splits[3]).append(" as ").append((StringUtils.isNotBlank(per) ? per+ "_" : "" )+splits[1]).append(",");
            coloumAs.add(sbb.toString());
            splits[3] = (StringUtils.isNotBlank(per)  ? per+ "_" : "") +splits[1];
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
