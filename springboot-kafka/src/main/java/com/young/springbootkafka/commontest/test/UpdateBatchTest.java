package com.young.springbootkafka.commontest.test;

/**
 * UpdateBatchTest
 *
 * @Author yangbing
 * @Date 2020/9/24 5:26 下午
 */
public class UpdateBatchTest {
    public static void main(String[] args) {
        String s1 = "username = #{username,jdbcType=VARCHAR},\n" +
                "        password = #{password,jdbcType=VARCHAR},\n" +
                "        realname = #{realname,jdbcType=VARCHAR}";
        String s2 = "id=#{item.id}";
        getUpdateBatch(s1, s2);
    }

    private static void getUpdateBatch(String s, String idC) {
        StringBuilder sb = new StringBuilder("<trim prefix=\"set\" suffixOverrides=\",\">\n");
        String[] split = s.split("\n");
        for (String s1 : split) {
            String s2 = s1.replace(",", " ").trim();
            String[] split1 = s2.split("=");
            String s3 = split1[1].trim().split(" ")[0].replace("#{", "");
            sb.append("<trim prefix=\"").append(split1[0]).append("=case\" suffix=\"end,\">\n");
            sb.append("<foreach collection=\"list\" item=\"item\" index=\"index\">\n");
            sb.append("<if test=\"item.").append(s3).append("!=null\">\n");
            sb.append("when ").append(idC).append(" then #{item.").append(s3).append("}\n");
            sb.append("</if>\n").append("</foreach>\n").append("</trim>\n");
        }
        sb.append("</trim>");
        System.out.println(sb.toString());
    }
}
