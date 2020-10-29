package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * GdwjysjXMLTest
 *
 * @author yangbing
 * @date 2020/10/29 2:25 下午
 */
public class GdwjysjXMLTest {

    public static final String FILE_PATH_GDWJYSJ = "src/main/resources/static/xml/归档文件元数据.XML";
    public static final String FILE_PATH_GDWJYSJ_OUT = "src/main/resources/static/xml/out/归档文件元数据.XML";

    private static JSONObject jsonObject = new JSONObject();

    static {
        jsonObject.put("WJBH", "WJBH");
        jsonObject.put("WJTM", "WJTM");
        jsonObject.put("ZRZ", "ZRZ");
        jsonObject.put("BZRQ", "BZRQ");
        jsonObject.put("WJLX", "WJLX");
    }

    private static List<JSONObject> jsonObjectList = new ArrayList<>();

    static {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", "title1");
        jsonObject.put("size", "size1");
        jsonObject.put("name", "name1");
        jsonObject.put("type", "type1");
        jsonObject.put("abstract", "abstract1");
        jsonObject.put("fileheader", "fileheader1");
        jsonObjectList.add(jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("title", "title2");
        jsonObject2.put("size", "size2");
        jsonObject2.put("name", "name2");
        jsonObject2.put("type", "type2");
        jsonObject2.put("abstract", "abstract2");
        jsonObject2.put("fileheader", "fileheader2");
        jsonObjectList.add(jsonObject2);
    }

    public static void main(String[] args) throws Exception {
        XmlUtils.generateGdwjysj(jsonObject, jsonObjectList, FILE_PATH_GDWJYSJ, FILE_PATH_GDWJYSJ_OUT);
    }
}
