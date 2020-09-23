package com.young.springbootkafka.commontest.test;

/**
 * ColoumTest2
 *
 * @Author yangbing
 * @Date 2020/9/22 4:02 下午
 */
public class ColoumTest2 {
    //<result property="createBy" column="CREATE_BY_" jdbcType="VARCHAR"/>
    public static void main(String[] args) {
        String s ="    private String pkOrg;\n" +
                "    private String supplier;\n" +
                "    private String objtype;\n" +
                "    private String pkCurrtype;\n" +
                "    private String pkDeptid;\n" +
                "    private String localMoneyCr;\n" +
                "    private String moneyCr;\n" +
                "    private String notaxCr;\n" +
                "    private String localNotaxCr;\n" +
                "    private String taxrate;\n" +
                "    private String buysellflag;\n" +
                "    private String def1;\n" +
                "    private String def3;\n" +
                "    private String def2;\n" +
                "    private String def5;\n" +
                "    private String def7;\n" +
                "    private String def8;\n" +
                "    private String sendcountryid;";
        getResult(s);
    }

    public static void getResult(String s){
        String[] split = s.split("\n");
        for (String s1 : split) {
            String[] s2 = s1.trim().split(" ");
            s2[2] = s2[2].split(";")[0];
            StringBuilder sb = new StringBuilder();
            sb.append("<result property=\"").append(s2[2]).append("\" column=\"").append(s2[2]).append("\" jdbcType=\"VARCHAR\"/>");
            System.out.println(sb.toString());
        }
    }
}
