package com.young.springbootkafka.commontest.utiltest;

/**
 * 生成resultMap
 *
 * @Author yangbing
 * @Date 2020/9/22 4:02 下午
 */
public class GenerateResultMap {
    public static void main(String[] args) {
        String s ="    private String serialNumber;\n" +
                "\n" +
                "    private String materialNo;\n" +
                "\n" +
                "    private String materialName;\n" +
                "\n" +
                "    private String materialClassificationNo;\n" +
                "\n" +
                "    private String materialClassificationName;\n" +
                "\n" +
                "    private String specificationType;\n" +
                "\n" +
                "    private String unit;\n" +
                "\n" +
                "    private String unitName;\n" +
                "\n" +
                "    private String number;\n" +
                "\n" +
                "    private String intaxPrice;\n" +
                "\n" +
                "    private String intaxAmount;\n" +
                "\n" +
                "    private String taxRate;\n" +
                "\n" +
                "    private String outtaxedUnitPrice;\n" +
                "\n" +
                "    private String outtaxedAmount;\n" +
                "\n" +
                "    private String lineNum;\n" +
                "\n" +
                "    private String line;\n" +
                "\n" +
                "    private String demandDepId;\n" +
                "\n" +
                "    private String demandDepName;\n" +
                "\n" +
                "    private String demanderId;\n" +
                "\n" +
                "    private String demanderName;\n" +
                "\n" +
                "    private String biddingBrand;\n" +
                "\n" +
                "    private String warranty;\n" +
                "\n" +
                "    private String assetClassificationNo;\n" +
                "\n" +
                "    private String assetClassificationName;\n" +
                "\n" +
                "    private String budgetType;\n" +
                "\n" +
                "    private String budgetTypeName;\n" +
                "\n" +
                "    @JsonProperty(\"isFixedCapital\")\n" +
                "    private String isFixedCapital;\n" +
                "    \n" +
                "    private String remarks;";
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
