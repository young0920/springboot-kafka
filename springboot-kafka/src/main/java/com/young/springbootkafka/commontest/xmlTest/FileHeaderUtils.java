package com.young.springbootkafka.commontest.xmlTest;

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
    /**
     * 得到文件头
     *
     * @param file
     *            文件
     * @return 文件头
     * @throws IOException
     */
    public static String getFileHead(File file) throws IOException {

        byte[] b = new byte[28];
        try(InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
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
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}
