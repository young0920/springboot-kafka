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
        //1.创建SAXReader对象用于读取xml文件
        SAXReader reader = new SAXReader();
        //2.读取xml文件，获得Document对象
        Document doc = reader.read(new File(FILE_PATH_SMWJ));
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            //设置属性值
            element.setText(jsonObject.getString(element.getName()));
        }

        //根据值写入新文件
        OutputFormat format = new OutputFormat();
        format.setEncoding("GBK");
        format.setSuppressDeclaration(false);
        XMLWriter writer = new XMLWriter(new FileOutputStream(FILE_PATH_SMWJ_OUT), format);
        writer.write(doc);
        writer.close();
    }
}
