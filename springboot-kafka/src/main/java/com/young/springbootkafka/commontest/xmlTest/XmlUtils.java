package com.young.springbootkafka.commontest.xmlTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * XmlUtils
 *
 * @author yangbing
 * @date 2020/10/29 3:55 下午
 */
public class XmlUtils {

    /**
     * 获取xml文件对象
     *
     * @param filePath 文件地址
     * @return document
     * @throws DocumentException
     */
    private static Document getDocument(String filePath) throws DocumentException {
        //1.创建SAXReader对象用于读取xml文件
        SAXReader reader = new SAXReader();
        //2.读取xml文件，获得Document对象
        return reader.read(new File(filePath));
    }

    /**
     * 生成说明文件
     *
     * @param jsonObject  内容
     * @param filePath    文件所在地址
     * @param filePathOut 输出文件地址
     * @throws Exception
     */
    public static void generateSmwj(JSONObject jsonObject, String filePath, String filePathOut) throws Exception {
        Document doc = getDocument(filePath);
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            //设置属性值
            element.setText(jsonObject.getString(element.getName()));
        }

        //根据值写入新文件
        outPutXml(filePathOut, doc);
    }

    /**
     * 生成归档案卷元数据
     *
     * @param jsonObject  内容
     * @param filePath    文件所在地址
     * @param filePathOut 输出文件地址
     * @throws Exception
     */
    public static void generateGdajysj(JSONObject jsonObject, String filePath, String filePathOut) throws Exception {
        Document doc = getDocument(filePath);
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        //遍历归档案卷元数据 著录项
        Iterator<Element> iterator = rootElement.element(XmlConstants.ITEM_ELEMENT).element(XmlConstants.FIELDS_ELEMENT).elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            //设置相应属性
            element.setText(jsonObject.getString(element.attributeValue(XmlConstants.ATTRIBUTE_ID)));
        }
        //根据值写入新文件
        outPutXml(filePathOut, doc);
    }


    /**
     * 生成归档文件元数据
     *
     * @param jsonObject     著录项
     * @param jsonObjectList 文件内容
     * @param filePath    文件所在地址
     * @param filePathOut 输出文件地址
     * @throws Exception
     */
    public static void generateGdwjysj(JSONObject jsonObject, List<JSONObject> jsonObjectList, String filePath, String filePathOut) throws Exception {
        Document doc = getDocument(filePath);
        //3.获取根节点
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.element(XmlConstants.ITEM_ELEMENT).elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (StringUtils.equals(element.getName(), XmlConstants.FIELDS_ELEMENT)) {
                //遍历生成归档文件元数据 著录项
                Iterator<Element> iterator2 = element.elementIterator();
                while (iterator2.hasNext()) {
                    Element element2 = iterator2.next();
                    element2.setText(jsonObject.getString(element2.attributeValue(XmlConstants.ATTRIBUTE_ID)));
                }
            }
            if (StringUtils.equals(element.getName(), XmlConstants.FILES_ELEMENT)) {
                Element element3 = element.element(XmlConstants.FILE_ELEMENT);
                //遍历生成归档文件元数据 文件信息
                forEachFileElement(jsonObjectList, element, element3);
            }
        }
        outPutXml(filePathOut, doc);

    }

    /**
     * 历生成归档文件元数据 文件信息
     * @param jsonObjectList 文件内容信息
     * @param element ITEM节点
     * @param element3 file 节点
     */
    static void forEachFileElement(List<JSONObject> jsonObjectList, Element element, Element element3) {
        jsonObjectList.forEach(jsonObject1 -> {
            Iterator<Element> iterator3 = element3.elementIterator();
            while (iterator3.hasNext()) {
                Element element4 = iterator3.next();
                //设置属性值
                element4.setText(jsonObject1.getString(element4.getName()));
            }
            element.add((Element) element3.clone());
        });
        element.remove(element3);
    }

    /**
     * 输出文件
     *
     * @param filePathOut 输出路径
     * @param doc         xml 对象
     * @throws IOException
     */
    private static void outPutXml(String filePathOut, Document doc) throws IOException {
        //根据值写入新文件
        OutputFormat format = new OutputFormat();
        format.setEncoding("GBK");
        format.setSuppressDeclaration(false);
        File file = new File(filePathOut);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        XMLWriter writer = new XMLWriter(new FileOutputStream(filePathOut), format);
        writer.write(doc);
        writer.close();
    }
}
