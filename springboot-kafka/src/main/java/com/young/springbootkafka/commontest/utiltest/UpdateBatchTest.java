package com.young.springbootkafka.commontest.utiltest;

/**
 * @Author yangbing
 * @Date 2020/9/24 5:26 下午
 */
public class UpdateBatchTest {
    public static void main(String[] args) {
        String str = "            UPDATE_BY_=#{updateBy,jdbcType=VARCHAR},\n" +
                "            UPDATE_TIME_=#{updateTime,jdbcType=TIMESTAMP},\n" +
                "            F_INVEST_TYPE=#{investType,jdbcType=VARCHAR},\n" +
                "            F_INVEST_TYPE_NAME=#{investTypeName,jdbcType=VARCHAR},\n" +
                "            F_PRO_CLASS=#{proClass,jdbcType=VARCHAR},\n" +
                "            F_PRO_CLASS_NAME=#{proClassName,jdbcType=VARCHAR},\n" +
                "            F_PRO_NAME=#{proName,jdbcType=VARCHAR},";
        String byWhat = "F_PRO_NO=#{item.proNo}";
        String table = "nrgz_pro_inf_base";
        //获取批量修改
        getUpdateBatch(str, byWhat, table);
        //拼接 if  text != null
//        getIfNullText(str);
    }

    private static void getUpdateBatch(String str, String byWhat, String table) {
        System.out.println("***********************批量修改开始*********************");
        StringBuilder sb = new StringBuilder("    <update id=\"updateBatch\" parameterType=\"java.util.List\">\n");
        sb.append("        UPDATE " + table + "\n");
        sb.append("        <trim prefix=\"set\" suffixOverrides=\",\">\n");
        String[] lineArray = str.split("\n");
        for (String eachLine : lineArray) {
            String trim = eachLine.replace(",", " ").trim();
            String[] coloumAndProperty = trim.split("=");
            String property = coloumAndProperty[1].trim().split(" ")[0].replace("#{", "");
            sb.append("            <trim prefix=\"").append(coloumAndProperty[0]).append("=case\" suffix=\"end,\">\n");
            sb.append("               <foreach collection=\"list\" item=\"item\" index=\"index\">\n");
            sb.append("                    <if test=\"item.").append(property).append(" != null\">\n");
            sb.append("                        when ").append(byWhat).append(" then #{item.").append(property).append("}\n");
            sb.append("                    </if>\n").append("                </foreach>\n").append("            </trim>\n");
        }
        sb.append("        </trim>\n");
        sb.append("        where\n" +
                "        <foreach collection=\"list\" separator=\"or\" item=\"item\" index=\"index\">\n");
        sb.append("            " + byWhat + "\n").append("        </foreach>\n");
        sb.append("    </update>");
        System.out.println(sb.toString());
        System.out.println("***********************批量修改接收*********************");
    }

    private static void getIfNullText(String str) {
        System.out.println("***********************拼接if text != null开始*********************");
        StringBuilder sb = new StringBuilder("        <set>\n");
        String[] lineArray = str.split("\n");
        for (String eachLine : lineArray) {
            String trim = eachLine.replace(",", " ").trim();
            String[] coloumAndProperty = trim.split("=");
            String property = coloumAndProperty[1].trim().split(" ")[0].replace("#{", "");
            sb.append("            <if test=\"").append(property).append(" != null\">\n");
            sb.append("                ").append(eachLine.trim() + "\n");
            sb.append("            </if>\n");
        }
        sb.append("        </set>");
        System.out.println(sb.toString());
        System.out.println("***********************拼接if text != null开始*********************");
    }
}
