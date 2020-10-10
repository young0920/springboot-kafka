package com.young.springbootkafka.service.impl;

import cn.hutool.core.date.DateUtil;
import com.young.springbootkafka.service.IMinioService;
import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * MinioServiceImpl
 *
 * @Author yangbing
 * @Date 2020/9/7 9:54 上午
 */
@Slf4j
@Service
public class MinioServiceImpl implements IMinioService {

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Resource
    private MinioClient client;

    /**
     * 外链过期时间，有两种方法
     * 1、可以通过命令设置共享域（桶）为 public 就可以永久外链了
     * 2、可以通过代码层返回文件流
     */
    private static final Integer EXPIRES = 7 * 3600;

    /**
     * 生成新文件名
     *
     * @param suffix
     * @return
     */
    private String newFileName(String suffix) {
        StringBuilder sb = new StringBuilder();
        String date = DateUtil.format(new Date(), "yyyy-MM-dd");
        sb.append(date).append("/");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        sb.append(uuid).append(".").append(suffix);
        return sb.toString();
    }


    @SneakyThrows
    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @SneakyThrows
    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, newFileName(suffix));
    }

    @SneakyThrows
    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            createBucket(bucketName);
            client.putObject(bucketName, path, inputStream, inputStream.available(), "application/octet-stream");
        } catch (Exception e) {
            log.error("上传文件失败", e);
        }
        return path;
    }

    @SneakyThrows
    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, newFileName(suffix));
    }

    @SneakyThrows
    @Override
    public void delete(String filePath) {
        client.removeObject(bucketName, filePath);
    }

    @SneakyThrows
    @Override
    public String getPresignedUrl(String filePath) {
        //外链路径
        return client.presignedGetObject(bucketName, filePath, EXPIRES);
    }

    @SneakyThrows
    @Override
    public InputStream getFileInputStream(String filePath) {
        return client.getObject(bucketName, filePath);
    }

    @SneakyThrows
    private void createBucket(String bucketName) {
        if (!client.bucketExists(bucketName)) {
            client.makeBucket(bucketName);
        }
    }
}
