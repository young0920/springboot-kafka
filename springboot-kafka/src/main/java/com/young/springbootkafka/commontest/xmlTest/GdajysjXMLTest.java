package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;

/**
 * XMLTest
 *
 * @author yangbing
 * @date 2020/10/27 9:54 上午
 */
public class GdajysjXMLTest {

    public static final String FILE_PATH_GDAJYSJ = "src/main/resources/static/xml/归档案卷元数据.XML";
    public static final String FILE_PATH_GDAJYSJ_OUT = "src/main/resources/static/xml/out/归档案卷元数据.XML";

    private static JSONObject jsonObject = new JSONObject();

    static {
        jsonObject.put("AJTM", "AJTM1");
        jsonObject.put("LJDW", "LJDW1");
        jsonObject.put("QSRQ", "QSRQ1");
        jsonObject.put("JSRQ", "JSRQ1");
        jsonObject.put("HTBH", "HTBH1");
        jsonObject.put("HTMC", "HTMC1");
        jsonObject.put("HTJB", "HTJB1");
        jsonObject.put("HTLX", "HTLX1");
        jsonObject.put("XMMC", "XMMC1");
        jsonObject.put("XLMC", "XLMC1");
        jsonObject.put("QDRQ", "QDRQ1");
        jsonObject.put("SXRQ", "SXRQ1");
        jsonObject.put("ZBBM", "ZBBM1");
        jsonObject.put("LYBM", "LYBM1");
        jsonObject.put("BGXYBH", "LJDW");
        jsonObject.put("BGXYMC", "LJDW");
    }


    public static void main(String[] args) throws Exception {
        XmlGenerateUtils.generateGdajysj(jsonObject, FILE_PATH_GDAJYSJ, FILE_PATH_GDAJYSJ_OUT);

    }
}
