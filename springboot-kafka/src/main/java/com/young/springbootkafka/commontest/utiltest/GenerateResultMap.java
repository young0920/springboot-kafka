package com.young.springbootkafka.commontest.utiltest;

/**
 * 生成resultMap
 *
 * @Author yangbing
 * @Date 2020/9/22 4:02 下午
 */
public class GenerateResultMap {
    public static void main(String[] args) {
        String s ="    private String uscc;\n" +
                "    private String supplierName;\n" +
                "    private String supplierNo;\n" +
                "    private String accountName;\n" +
                "    private String bankName;\n" +
                "    private String bankBranchName;\n" +
                "    private String bankAccount;\n" +
                "    private String bankID;\n" +
                "    private String bankType;\n" +
                "    private String branchNumber;\n" +
                "    @JsonProperty(value = \"isDelete\")\n" +
                "    private String isDelete;";
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
