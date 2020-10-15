package com.young.springbootkafka.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.CharEncoding;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * ResponseUtils
 *
 * @Author yangbing
 * @Date 2020/10/15 5:09 下午
 */
public class ResponseUtils {
    /**
     * 返回JSON数据
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    public static <T> void responseJson(HttpServletResponse response, T obj) throws Exception {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(CharEncoding.UTF_8);
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSONString(obj));
        writer.close();
        response.flushBuffer();
    }
}
