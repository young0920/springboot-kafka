package com.young.springbootkafka.util;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * HMAC-SHA1 加密算法工具类
 *
 * @Author yangbing
 * @Date 2020/8/18 3:02 下午
 */
public class SignatureUtils {

    private static final String HMAC_SHA_1 = "HmacSHA1";

    public static String signature(String appId, String appKey, String timeStamp) throws Exception {
        String message = appId + appKey + timeStamp;
        return signature(message, appKey);
    }

    /**
     * 签名
     *
     * @param message 签名的字符串
     * @param key     密钥
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String signature(String message, String key) throws Exception {
        byte[] byteMsg = message.getBytes(StandardCharsets.UTF_8);
        byte[] byteKey = key.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec signKey = new SecretKeySpec(byteKey, HMAC_SHA_1);
        Mac mac = Mac.getInstance(HMAC_SHA_1);
        mac.init(signKey);
        byte[] encodeArray = mac.doFinal(byteMsg);
        return byte2HexString(encodeArray);
    }

    /**
     * 二进制转十六进制
     *
     * @param b
     * @return
     */
    public static String byte2HexString(byte[] b) {
        StringBuilder r = new StringBuilder();
        for (byte value : b) {
            String hex = Integer.toHexString(value & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r.append(hex);
        }
        return r.toString();
    }

}
