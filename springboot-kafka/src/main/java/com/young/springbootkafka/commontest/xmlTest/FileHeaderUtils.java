package com.young.springbootkafka.commontest.xmlTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileHeaderUtils
 *
 * @author yangbing
 * @date 2020/10/29 5:22 下午
 */
public class FileHeaderUtils {

    private static Logger logger = LoggerFactory.getLogger(FileHeaderUtils.class);

    /**
     * 得到文件头
     *
     * @param filePath 文件路径
     * @param len      长度
     * @return string
     */
    public static String getFileHeader(String filePath, int len) {
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(filePath);
            byte[] b = new byte[len];
            /*
             * int read() 从此输入流中读取一个数据字节。 int read(byte[] b) 从此输入流中将最多 b.length
             * 个字节的数据读入一个 byte 数组中。 int read(byte[] b, int off, int len)
             * 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。
             */
            is.read(b, 0, b.length);
            value = bytesToHexString(b, len);
            if (value == null) {
                value = "";
            }
        } catch (Exception e) {
            logger.error("获取文件头是失败", e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("关闭流失败", e);
                }
            }
        }
        return value;
    }

    /**
     * 将要读取文件头信息的文件的byte数组转换成String类型表示
     *
     * @param src 要读取文件头信息的文件的byte数组
     * @return 文件头信息
     */
    private static String bytesToHexString(byte[] src, int len) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < len; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }


    /**
     * 得到文件头
     *
     * @param file 文件
     * @return 文件头
     */
    public static String getFileHeader(File file) {

        byte[] b = new byte[28];
        try (InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            logger.error("获取16进制文件头失败", e);
            throw new RuntimeException("获取16进制文件头失败");
        }
        return bytesToHexString(b);
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param src 原生byte
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        String p1="/Users/young/SvnWorkPlace/Temp/HTXT1620201106/HTXT16/2700000005630033.docx";
        String p2 ="/Users/young/SvnWorkPlace/Temp/HTXT1620201106/HTXT16/2700000005630223.xlsx";
        System.out.println(getFileHeader(p1,4));
        System.out.println(getFileHeader(p2,4));

    }
}
