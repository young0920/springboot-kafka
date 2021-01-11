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
        String s = "\t\t<result property=\"belongCompany\" column=\"F_BELONG_COMPANY\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"belongCompanyName\" column=\"F_BELONG_COMPANY_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractEffectiveDate\" column=\"F_CONTRACT_EFFECTIVE_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"contractLevel\" column=\"F_CONTRACT_LEVEL\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractName\" column=\"F_CONTRACT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNo\" column=\"F_CONTRACT_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNoName\" column=\"F_CONTRACT_NO_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractState\" column=\"F_CONTRACT_STATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractType\" column=\"F_CONTRACT_TYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"dealScore\" column=\"F_DEAL_SCORE\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"djmc\" column=\"F_DJMC\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"docNo\" column=\"F_DOC_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateAttentionItem\" column=\"F_EVALUATE_ATTENTION_ITEM\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluatePerson\" column=\"F_EVALUATE_PERSON\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluatePersonName\" column=\"F_EVALUATE_PERSON_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateQuarter\" column=\"F_EVALUATE_QUARTER\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateQuarterName\" column=\"F_EVALUATE_QUARTER_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateTemplate\" column=\"F_EVALUATE_TEMPLATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateTemplateName\" column=\"F_EVALUATE_TEMPLATE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateYear\" column=\"F_EVALUATE_YEAR\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"evaluateYearName\" column=\"F_EVALUATE_YEAR_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"indentGrade\" column=\"F_INDENT_GRADE\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"nowAmount\" column=\"F_NOW_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"orignAmount\" column=\"F_ORIGN_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"procState\" column=\"F_PROC_STATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"procStateName\" column=\"F_PROC_STATE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"quarterGrade\" column=\"F_QUARTER_GRADE\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"reviewPerson\" column=\"F_REVIEW_PERSON\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"reviewPersonName\" column=\"F_REVIEW_PERSON_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"scoreDate\" column=\"F_SCORE_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"vendorName\" column=\"F_VENDOR_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"yearGrade\" column=\"F_YEAR_GRADE\" jdbcType=\"NUMERIC\"/>";
        getColoum(s,"c8");
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
