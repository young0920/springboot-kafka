package com.young.springbootkafka.util;

import cn.hutool.core.util.IdUtil;
import org.springframework.util.Base64Utils;

/**
 * ApiTokenUtols
 *
 * @author yangbing
 * @date 2021/1/14 下午8:28
 */
public class ApiTokenUtils {
    /**
     * 获取token
     * @return token
     */
    public static String getToken() {
        String tokenStr = IdUtil.simpleUUID();
        return Base64Utils.encodeToString(tokenStr.getBytes());
    }
}
