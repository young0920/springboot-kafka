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
     * @return 返回存储路径
     */
    String upload(byte[] data, String path);

    /**
     * 文件上传
     *
     * @param data   文件字节数组
     * @param suffix 后缀
     * @return 返回存储路径
     */
    String uploadSuffix(byte[] data, String suffix);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回存储路径
     */
    String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param suffix      后缀
     * @return 返回存储路径
     */
    String uploadSuffix(InputStream inputStream, String suffix);

    /**
     * 文件删除
     * @param filePath 文件存储路径
     */
    void delete(String filePath);

    /**
     * 获取文件外链路径
     * @param filePath 文件存储路径
     * @return 返回http地址
     */
    String getPresignedUrl(String filePath);

    /**
     *
     * 获取文件流
     * @param filePath 文件存储路径
     * @return 返回文件流
     */
    InputStream getFileInputStream(String filePath);
}
