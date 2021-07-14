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
        String s = "\t\t<result property=\"docNo\" column=\"F_DOC_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"docName\" column=\"F_DOC_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"belongCompany\" column=\"F_BELONG_COMPANY\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"belongCompanyName\" column=\"F_BELONG_COMPANY_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"procState\" column=\"F_PROC_STATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"procStateName\" column=\"F_PROC_STATE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractName\" column=\"F_CONTRACT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNo\" column=\"F_CONTRACT_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNoName\" column=\"F_CONTRACT_NO_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"signDate\" column=\"F_SIGN_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"contractClass\" column=\"F_CONTRACT_CLASS\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractClassName\" column=\"F_CONTRACT_CLASS_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractLevel\" column=\"F_CONTRACT_LEVEL\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractLevelName\" column=\"F_CONTRACT_LEVEL_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractAmount\" column=\"F_CONTRACT_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"line\" column=\"F_LINE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineName\" column=\"F_LINE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"vendor\" column=\"F_VENDOR\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"sponsorDept\" column=\"F_SPONSOR_DEPT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"sponsorDeptName\" column=\"F_SPONSOR_DEPT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"terminateReason\" column=\"F_TERMINATE_REASON\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"terminateType\" column=\"F_TERMINATE_TYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"terminateTypeName\" column=\"F_TERMINATE_TYPE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"terminateParties\" column=\"F_TERMINATE_PARTIES\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"terminatePartiesName\" column=\"F_TERMINATE_PARTIES_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"isOppositeCause\" column=\"F_IS_OPPOSITE_CAUSE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"isOppositeCauseName\" column=\"F_IS_OPPOSITE_CAUSE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"endDate\" column=\"F_END_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"isDealEnd\" column=\"F_IS_DEAL_END\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"isDealEndName\" column=\"F_IS_DEAL_END_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handleDept\" column=\"F_HANDLE_DEPT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handleDeptName\" column=\"F_HANDLE_DEPT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handlePerson\" column=\"F_HANDLE_PERSON\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handlePersonName\" column=\"F_HANDLE_PERSON_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handleDate\" column=\"F_HANDLE_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"receivableAmount\" column=\"F_RECEIVABLE_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"receivedAmount\" column=\"F_RECEIVED_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"waitingAmount\" column=\"F_WAITING_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"refundAmount\" column=\"F_REFUND_AMOUNT\" jdbcType=\"NUMERIC\"/>";
        getColoum(s,"tmn");
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
