package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
    public static final String ITEM_ELEMENT = "ITEM";
    public static final String FIELDS_ELEMENT = "fields";
    public static final String FILES_ELEMENT = "files";
    public static final String FILE_ELEMENT = "file";
    public static final String ATTRIBUTE_ID = "id";

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
        //1.创建SAXReader对象用于读取xml文件
        SAXReader reader = new SAXReader();
        //2.读取xml文件，获得Document对象
        Document doc = reader.read(new File(FILE_PATH_GDWJYSJ));
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.element(ITEM_ELEMENT).elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if(StringUtils.equals(element.getName(),FIELDS_ELEMENT)){
                Iterator<Element> iterator2 = element.elementIterator();
                while (iterator2.hasNext()){
                    Element element2 = iterator2.next();
                    element2.setText(jsonObject.getString(element2.attributeValue(ATTRIBUTE_ID)));
                }
            }
            if(StringUtils.equals(element.getName(),FILES_ELEMENT)){
                Element element3 = element.element(FILE_ELEMENT);
                XmlUtils.forEachFileElement(jsonObjectList, element, element3);
            }
        }

        //根据值写入新文件
        OutputFormat format = new OutputFormat();
        format.setEncoding("GBK");
        format.setSuppressDeclaration(false);
        File file = new File(FILE_PATH_GDWJYSJ_OUT);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        XMLWriter writer = new XMLWriter(new FileOutputStream(FILE_PATH_GDWJYSJ_OUT), format);
        writer.write(doc);
        writer.close();
    }
}
