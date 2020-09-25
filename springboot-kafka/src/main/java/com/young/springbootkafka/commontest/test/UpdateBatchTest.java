package com.young.springbootkafka.commontest.test;

/**
 * @Author yangbing
 * @Date 2020/9/24 5:26 下午
 */
public class UpdateBatchTest {
    public static void main(String[] args) {
        String coloum = "\t\tCREATE_BY_=#{createBy,jdbcType=VARCHAR},\n" +
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
        getUpdateBatch(coloum, byWhat, table);
    }

    private static void getUpdateBatch(String coloum, String byWhat, String table) {
        StringBuilder sb = new StringBuilder("    <update id=\"updateBatch\" parameterType=\"java.util.List\">\n");
        sb.append("        UPDATE " + table + " SET\n");
        sb.append("        <trim prefix=\"set\" suffixOverrides=\",\">\n");
        String[] split = coloum.split("\n");
        for (String s1 : split) {
            String s2 = s1.replace(",", " ").trim();
            String[] split1 = s2.split("=");
            String s3 = split1[1].trim().split(" ")[0].replace("#{", "");
            sb.append("            <trim prefix=\"").append(split1[0]).append("=case\" suffix=\"end,\">\n");
            sb.append("               <foreach collection=\"list\" item=\"item\" index=\"index\">\n");
            sb.append("                    <if test=\"item.").append(s3).append(" != null\">\n");
            sb.append("                        when ").append(byWhat).append(" then #{item.").append(s3).append("}\n");
            sb.append("                    </if>\n").append("                </foreach>\n").append("            </trim>\n");
        }
        sb.append("        </trim>\n");
        sb.append("        where\n" +
                "        <foreach collection=\"list\" separator=\"or\" item=\"item\" index=\"index\">\n");
        sb.append("            " + byWhat + "\n").append("        </foreach>\n");
        sb.append("    </update>");
        System.out.println(sb.toString());
    }
}
