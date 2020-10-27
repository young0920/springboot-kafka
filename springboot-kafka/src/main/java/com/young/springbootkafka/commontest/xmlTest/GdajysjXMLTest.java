package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

/**
 * XMLTest
 *
 * @author yangbing
 * @date 2020/10/27 9:54 上午
 */
public class GdajysjXMLTest {

    public static final String FILE_PATH_GDAJYSJ = "src/main/resources/static/xml/归档案卷元数据.XML";
    public static final String ITEM_ELEMENT = "ITEM";
    public static final String FIELDS_ELEMENT = "fields";
    public static final String ATTRIBUTE_ID = "id";

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
        //1.创建SAXReader对象用于读取xml文件
        SAXReader reader = new SAXReader();
        //2.读取xml文件，获得Document对象
        Document doc = reader.read(new File(FILE_PATH_GDAJYSJ));
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.element(ITEM_ELEMENT).element(FIELDS_ELEMENT).elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            element.setText(jsonObject.getString(element.attributeValue(ATTRIBUTE_ID)));
        }
        //根据值写入新文件
        OutputFormat format = new OutputFormat();
        format.setSuppressDeclaration(false);
        XMLWriter writer = new XMLWriter(new FileOutputStream(FILE_PATH_GDAJYSJ), format);
        writer.write(doc);
        writer.close();
    }
}
