package com.young.springbootkafka.commontest.utiltest;

/**
 * @Author yangbing
 * @Date 2020/9/24 5:26 下午
 */
public class UpdateBatchTest {
    public static void main(String[] args) {
        String str = "\t\tCREATE_BY_=#{createBy,jdbcType=VARCHAR},\n" +
                "\t\tCREATE_TIME_=#{createTime,jdbcType=TIMESTAMP},\n" +
                "\t\tF_ASSIST_ACCOUNTING=#{assistAccounting,jdbcType=VARCHAR},\n" +
                "\t\tF_CASH_TYPE=#{cashType,jdbcType=VARCHAR},\n" +
                "\t\tF_CASH_TYPE_NAME=#{cashTypeName,jdbcType=VARCHAR},\n" +
                "\t\tF_CREATE_ACCOUNT=#{createAccount,jdbcType=VARCHAR},\n" +
                "\t\tF_FAMILY_SUBJECT_NO=#{familySubjectNo,jdbcType=VARCHAR},\n" +
                "\t\tF_MNEMONIC_CODE=#{mnemonicCode,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_DIRECTION=#{subjectDirection,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_DIRECTION_NAME=#{subjectDirectionName,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_NAME=#{subjectName,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_NO=#{subjectNo,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_TYPE=#{subjectType,jdbcType=VARCHAR},\n" +
                "\t\tF_SUBJECT_TYPE_NAME=#{subjectTypeName,jdbcType=VARCHAR},\n" +
                "\t\tGROUP_ID_=#{groupId,jdbcType=VARCHAR},\n" +
                "\t\tINST_ID_=#{instId,jdbcType=VARCHAR},\n" +
                "\t\tINST_STATUS_=#{instStatus,jdbcType=VARCHAR},\n" +
                "\t\tPARENT_ID_=#{parentId,jdbcType=VARCHAR},\n" +
                "\t\tREF_ID_=#{refId,jdbcType=VARCHAR},\n" +
                "\t\tTENANT_ID_=#{tenantId,jdbcType=VARCHAR},\n" +
                "\t\tUPDATE_BY_=#{updateBy,jdbcType=VARCHAR},\n" +
                "\t\tUPDATE_TIME_=#{updateTime,jdbcType=TIMESTAMP}";
        String byWhat = "ID_=#{item.id}";
        String table = "nrcm_accounting_subject";
        //获取批量修改
        getUpdateBatch(str, byWhat, table);
        //拼接 if  text != null
        getIfNullText(str);
    }

    private static void getUpdateBatch(String str, String byWhat, String table) {
        System.out.println("***********************批量修改开始*********************");
        StringBuilder sb = new StringBuilder("    <update id=\"updateBatch\" parameterType=\"java.util.List\">\n");
        sb.append("        UPDATE " + table + " SET\n");
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
