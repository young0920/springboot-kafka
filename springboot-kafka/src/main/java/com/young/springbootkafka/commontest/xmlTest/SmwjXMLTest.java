package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;

/**
 * XMLTest
 *
 * @author yangbing
 * @date 2020/10/27 9:54 上午
 */
public class SmwjXMLTest {

    public static final String FILE_PATH_SMWJ = "src/main/resources/static/xml/说明文件.XML";
    public static final String FILE_PATH_SMWJ_OUT = "src/main/resources/static/xml/out/说明文件.XML";

    private static JSONObject jsonObject = new JSONObject();

    static {
        jsonObject.put("kbm", "kbm");
        jsonObject.put("ztbh", "ztbh");
        jsonObject.put("wjjmc", "wjjmc");
        jsonObject.put("zzsj", "zzsj");
        jsonObject.put("lddwmc", "lddwmc");
        jsonObject.put("nd", "nd");
        jsonObject.put("gdwjsl", "gdwjsl");
        jsonObject.put("xxxtmc", "xxxtmc");
    }


    public static void main(String[] args) throws Exception {

        XmlGenerateUtils.generateSmwj(jsonObject,FILE_PATH_SMWJ,FILE_PATH_SMWJ_OUT);

    }
}
