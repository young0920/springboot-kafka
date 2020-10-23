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
        String s = "<result property=\"uscc\" column=\"uscc\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"supplierName\" column=\"supplierName\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"supplierNo\" column=\"supplierNo\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"accountName\" column=\"accountName\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"bankName\" column=\"bankName\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"bankBranchName\" column=\"bankBranchName\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"bankAccount\" column=\"bankAccount\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"bankID\" column=\"bankID\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"bankType\" column=\"bankType\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"branchNumber\" column=\"branchNumber\" jdbcType=\"VARCHAR\"/>\n" +
                "<result property=\"isDelete\" column=\"isDelete\" jdbcType=\"VARCHAR\"/>";
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
