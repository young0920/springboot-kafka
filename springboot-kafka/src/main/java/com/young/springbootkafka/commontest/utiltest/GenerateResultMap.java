package com.young.springbootkafka.commontest.utiltest;

/**
 * 生成resultMap
 *
 * @Author yangbing
 * @Date 2020/9/22 4:02 下午
 */
public class GenerateResultMap {
    public static void main(String[] args) {
        String s ="    private String dpsType;\n" +
                "    private String dpsName;\n" +
                "    private String dpsNo;\n" +
                "    private String dpsAmount;";
        getResult(s);
    }

    public static void getResult(String s){
        String[] lineArray = s.split("\n");
        for (String eachLine : lineArray) {
            if(!eachLine.trim().startsWith("private") && !eachLine.trim().startsWith("protected")){
                continue;
            }
            String[] property = eachLine.trim().split(" ");
            property[2] = property[2].split(";")[0];
            StringBuilder sb = new StringBuilder();
            sb.append("<result property=\"").append(property[2]).append("\" column=\"").append(property[2]).append("\" jdbcType=\"VARCHAR\"/>");
            System.out.println(sb.toString());
        }
    }
}
