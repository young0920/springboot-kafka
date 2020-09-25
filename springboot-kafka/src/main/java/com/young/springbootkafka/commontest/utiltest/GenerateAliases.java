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
        String s = "\t\t<result property=\"docName\" column=\"F_DOC_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"docNo\" column=\"F_DOC_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"belongCompany\" column=\"F_BELONG_COMPANY\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"belongCompanyName\" column=\"F_BELONG_COMPANY_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"procState\" column=\"F_PROC_STATE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"procStateName\" column=\"F_PROC_STATE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractName\" column=\"F_CONTRACT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNo\" column=\"F_CONTRACT_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractNoName\" column=\"F_CONTRACT_NO_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"signDate\" column=\"F_SIGN_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"contractType\" column=\"F_CONTRACT_TYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractTypeName\" column=\"F_CONTRACT_TYPE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractLevel\" column=\"F_CONTRACT_LEVEL\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"contractLevelName\" column=\"F_CONTRACT_LEVEL_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"originAmount\" column=\"F_ORIGIN_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"nowAmount\" column=\"F_NOW_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"vendor\" column=\"F_VENDOR\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"sponsorDept\" column=\"F_SPONSOR_DEPT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"sponsorDeptName\" column=\"F_SPONSOR_DEPT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"line\" column=\"F_LINE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"lineName\" column=\"F_LINE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectType\" column=\"F_COLLECT_TYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectTypeName\" column=\"F_COLLECT_TYPE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"planCollectDate\" column=\"F_PLAN_COLLECT_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"planCollectAmount\" column=\"F_PLAN_COLLECT_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"handleDept\" column=\"F_HANDLE_DEPT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handleDeptName\" column=\"F_HANDLE_DEPT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectDesc\" column=\"F_COLLECT_DESC\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"receiveAmount\" column=\"F_RECEIVE_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"handlePerson\" column=\"F_HANDLE_PERSON\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"handlePersonName\" column=\"F_HANDLE_PERSON_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"remainAmount\" column=\"F_REMAIN_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"handleDate\" column=\"F_HANDLE_DATE\" jdbcType=\"TIMESTAMP\"/>\n" +
                "\t\t<result property=\"invoiceType\" column=\"F_INVOICE_TYPE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"invoiceTypeName\" column=\"F_INVOICE_TYPE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"invoiceAmount\" column=\"F_INVOICE_AMOUNT\" jdbcType=\"NUMERIC\"/>\n" +
                "\t\t<result property=\"payeeName\" column=\"F_PAYEE_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payeeNameName\" column=\"F_PAYEE_NAME_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payTaxNo\" column=\"F_PAY_TAX_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payOpenBank\" column=\"F_PAY_OPEN_BANK\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payBankBranch\" column=\"F_PAY_BANK_BRANCH\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payBankAccount\" column=\"F_PAY_BANK_ACCOUNT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payAddress\" column=\"F_PAY_ADDRESS\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"payPhone\" column=\"F_PAY_PHONE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectTaxNo\" column=\"F_COLLECT_TAX_NO\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectOpenBank\" column=\"F_COLLECT_OPEN_BANK\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectBankBranch\" column=\"F_COLLECT_BANK_BRANCH\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectBankAccount\" column=\"F_COLLECT_BANK_ACCOUNT\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectAddress\" column=\"F_COLLECT_ADDRESS\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectPhone\" column=\"F_COLLECT_PHONE\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"claimStatusName\" column=\"F_CLAIM_STATUS_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"clainPersonName\" column=\"F_CLAIN_PERSON_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"rzStatusName\" column=\"F_RZ_STATUS_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectmoneystatus\" column=\"F_COLLECTMONEYSTATUS\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectmoneystatusName\" column=\"F_COLLECTMONEYSTATUS_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectPlanId\" column=\"F_COLLECT_PLAN_ID\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectName\" column=\"F_COLLECT_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "\t\t<result property=\"collectNameName\" column=\"F_COLLECT_NAME_NAME\" jdbcType=\"VARCHAR\"/>";
        getColoum(s,"p1");
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
