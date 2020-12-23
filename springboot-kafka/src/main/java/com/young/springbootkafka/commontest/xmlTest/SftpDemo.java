package com.young.springbootkafka.commontest.xmlTest;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * SFTPUtils
 *
 * @author young
 * @date 2020/12/21 下午4:56
 */
@Slf4j
public class SftpDemo {

    private static Session sshSession;

    /**
     * 连接sftp服务器
     *
     * @param host     ftp地址
     * @param port     端口
     * @param userName 账号
     * @param password 密码
     * @return channelSftp
     */
    public static ChannelSftp sftpConnection(String host, int port, String userName, String password) {
        JSch jsch = new JSch();
        ChannelSftp channelSftp = null;
        try {
            jsch.getSession(userName, host, port);
            sshSession = jsch.getSession(userName, host, port);
            sshSession.setPassword(password);
            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(properties);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
        } catch (JSchException e) {
            log.error("Sftp服务器登录异常!", e);
        }
        return channelSftp;
    }

    /**
     * 退出Sftp服务器登录
     *
     * @param channelSftp
     */
    public static void sftpClose(ChannelSftp channelSftp) {
        if (channelSftp == null) {
            return;
        }
        if (channelSftp.isConnected()) {
            channelSftp.disconnect();
        }
    }

    /**
     * 关闭session
     */
    public static void sessionClose() {
        if (sshSession == null) {
            return;
        }
        if (sshSession.isConnected()) {
            sshSession.disconnect();
            sshSession = null;
        }
    }

    /**
     * 下载sftp文件
     *
     * @param sftp        sftp
     * @param fileName    文件名称
     * @param path        文件路径
     * @param newFileName 存储文件名称
     * @param targetPath  下载到本地的路径
     */
    public static void downSftpFile(ChannelSftp sftp, String fileName, String path, String newFileName, String targetPath) {
        File targetFile = new File(targetPath + fileName);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }

        try (OutputStream os = new FileOutputStream(targetFile)) {
            if (path != null && !"".equals(path)) {
                //进入所在路径
                sftp.cd(path);
            }
            //获取文件
            sftp.get(path + newFileName, os);
        } catch (Exception e) {
            log.error("下载sftp文件失败！", e);
            throw new RuntimeException("下载sftp文件失败！", e);
        }
    }

    public static void main(String[] args) {
        ChannelSftp cs = sftpConnection("192.168.0.22", 22, "root", "yongyou,232");
        try {
            downSftpFile(cs, "抽象服务开发标准.doc", "/data/share/cm/zhou_c@nari.cn/202012/", "2700000006000721.doc",
                    "/Users/young/Downloads/");
        } catch (Exception e) {
            log.error("下载sftp文件失败！", e);
        } finally {
            sessionClose();
            sftpClose(cs);
        }
    }
}
