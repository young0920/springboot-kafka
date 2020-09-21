package com.young.springbootkafka.commontest.test;

import java.util.ArrayList;
import java.util.List;

/**
 * TestB
 *
 * @Author yangbing
 * @Date 2020/9/18 2:48 下午
 */
public class TestB {
    public static void main(String[] args) {
        String s = "            <result property=\"approvalDocId\" column=\"F_APPROVAL_DOC_ID\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"approvalDocName\" column=\"F_APPROVAL_DOC_NAME\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"docState\" column=\"F_DOC_STATE\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"entryDate\" column=\"F_ENTRY_DATE\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"leaveAdd\" column=\"F_LEAVE_ADD\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"docSource\" column=\"F_DOC_SOURCE\" jdbcType=\"VARCHAR\"/>\n" +
                "            <result property=\"docSourceName\" column=\"F_DOC_SOURCE_NAME\" jdbcType=\"VARCHAR\"/>";
        getColoum(s,"docinf");
    }

    private static void getColoum(String str,String per){
        String[] split = str.split("\n");
        List<String> strl = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split("\"");
            StringBuilder sbb = new StringBuilder();
            sbb.append(per).append(".").append(split1[3]).append(" as ").append(per+ "_" +split1[1]).append(",");
            strl.add(sbb.toString());
            split1[3] = per+ "_" +split1[1];
            StringBuilder sb = new StringBuilder();
            for (String s1 : split1) {
                sb.append(s1).append("\"");
            }
            String substring = sb.substring(0, sb.length() - 1);
            System.out.println(substring);
        }
        strl.forEach(s -> System.out.println(s));
    }
}
