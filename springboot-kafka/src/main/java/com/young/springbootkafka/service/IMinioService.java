package com.young.springbootkafka.service;


import java.io.InputStream;

/**
 * IMinioService
 *
 * @Author yangbing
 * @Date 2020/9/7 9:52 上午
 */
public interface IMinioService {
    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param path 文件路径，包含文件名
     * @return 返回http地址
     */
    String upload(byte[] data, String path);

    /**
     * 文件上传
     *
     * @param data   文件字节数组
     * @param suffix 后缀
     * @return 返回http地址
     */
    String uploadSuffix(byte[] data, String suffix);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回http地址
     */
    String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param suffix      后缀
     * @return 返回http地址
     */
    String uploadSuffix(InputStream inputStream, String suffix);

    /**
     * 文件删除
     * @param filePath
     * @return
     */
    void delete(String filePath);
}
