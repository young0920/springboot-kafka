package com.young.springbootkafka.commontest.test;

/**
 * 生成resultMap
 *
 * @Author yangbing
 * @Date 2020/9/22 4:02 下午
 */
public class GenerateResultMap {
    public static void main(String[] args) {
        String s ="@FieldDefine(title = \"主键\")\n" +
                "\t@Id\n" +
                "\t@Column(name = \"ID_\")\n" +
                "\tprotected String id;\n" +
                "\n" +
                "\t@FieldDefine(title = \"物资名称\")\n" +
                "\t@Column(name = \"F_BILL_NAME\")\n" +
                "\tprotected String billName; \n" +
                "\t@FieldDefine(title = \"物资编码\")\n" +
                "\t@Column(name = \"F_BILL_NO\")\n" +
                "\tprotected String billNo; \n" +
                "\t@FieldDefine(title = \"物资类型\")\n" +
                "\t@Column(name = \"F_BUDGET_TYPE\")\n" +
                "\tprotected String budgetType; \n" +
                "\t@FieldDefine(title = \"材料员确认\")\n" +
                "\t@Column(name = \"F_CLYQR_USR\")\n" +
                "\tprotected String clyqrUsr; \n" +
                "\t@FieldDefine(title = \"待送货数量\")\n" +
                "\t@Column(name = \"F_DSH_QTY\")\n" +
                "\tprotected Double dshQty; \n" +
                "\t@FieldDefine(title = \"合同数量\")\n" +
                "\t@Column(name = \"F_HTCG_QTY\")\n" +
                "\tprotected Double htcgQty; \n" +
                "\t@FieldDefine(title = \"计量单位\")\n" +
                "\t@Column(name = \"F_MEASURE_UNIT\")\n" +
                "\tprotected String measureUnit; \n" +
                "\t@FieldDefine(title = \"规格型号\")\n" +
                "\t@Column(name = \"F_MODEL_SPEC\")\n" +
                "\tprotected String modelSpec; \n" +
                "\t@FieldDefine(title = \"订单编号\")\n" +
                "\t@Column(name = \"F_ORDERLINE_NO\")\n" +
                "\tprotected String orderlineNo; \n" +
                "\t@FieldDefine(title = \"入库金额\")\n" +
                "\t@Column(name = \"F_PDB_AMT\")\n" +
                "\tprotected Double pdbAmt; \n" +
                "\t@FieldDefine(title = \"接收单价（含税）\")\n" +
                "\t@Column(name = \"F_PDB_PRC\")\n" +
                "\tprotected Double pdbPrc; \n" +
                "\t@FieldDefine(title = \"入库数量\")\n" +
                "\t@Column(name = \"F_PDB_QTY\")\n" +
                "\tprotected Double pdbQty; \n" +
                "\t@FieldDefine(title = \"送货数量\")\n" +
                "\t@Column(name = \"F_SH_QTY\")\n" +
                "\tprotected Double shQty; \n" +
                "\t@FieldDefine(title = \"实际入库时间\")\n" +
                "\t@Column(name = \"F_SJRKSJ_DAT\")\n" +
                "\tprotected java.util.Date sjrksjDat; \n" +
                "\t@FieldDefine(title = \"实际验收时间\")\n" +
                "\t@Column(name = \"F_SJYSSJ_DAT\")\n" +
                "\tprotected java.util.Date sjyssjDat; \n" +
                "\t@FieldDefine(title = \"税率\")\n" +
                "\t@Column(name = \"F_TAX_RATE\")\n" +
                "\tprotected Double taxRate; \n" +
                "\t@FieldDefine(title = \"退货数量\")\n" +
                "\t@Column(name = \"F_TH_QTY\")\n" +
                "\tprotected Double thQty; \n" +
                "\t@FieldDefine(title = \"接受单价（不含税）\")\n" +
                "\t@Column(name = \"F_UNT_PRC\")\n" +
                "\tprotected Double untPrc; \n" +
                "\t@FieldDefine(title = \"验收数量\")\n" +
                "\t@Column(name = \"F_YS_QTY\")\n" +
                "\tprotected Double ysQty; \n" +
                "\t@FieldDefine(title = \"验收人确认\")\n" +
                "\t@Column(name = \"F_YSRQR_USR\")\n" +
                "\tprotected String ysrqrUsr; \n" +
                "\t@FieldDefine(title = \"预约验收时间\")\n" +
                "\t@Column(name = \"F_YYYSSJ_DAT\")\n" +
                "\tprotected java.util.Date yyyssjDat; \n" +
                "\t@FieldDefine(title = \"组ID\")\n" +
                "\t@Column(name = \"GROUP_ID_\")\n" +
                "\tprotected String groupId; \n" +
                "\t@FieldDefine(title = \"流程实例ID\")\n" +
                "\t@Column(name = \"INST_ID_\")\n" +
                "\tprotected String instId; \n" +
                "\t@FieldDefine(title = \"状态\")\n" +
                "\t@Column(name = \"INST_STATUS_\")\n" +
                "\tprotected String instStatus; \n" +
                "\t@FieldDefine(title = \"父ID\")\n" +
                "\t@Column(name = \"PARENT_ID_\")\n" +
                "\tprotected String parentId; \n" +
                "\t@FieldDefine(title = \"外键\")\n" +
                "\t@Column(name = \"REF_ID_\")\n" +
                "\tprotected String refId;";
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
