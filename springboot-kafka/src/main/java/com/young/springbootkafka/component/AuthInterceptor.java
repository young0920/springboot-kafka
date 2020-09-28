package com.young.springbootkafka.component;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 拦截器配置（只能处理到类中的方法，但是不能记录方法的参数是什么）
 *
 * @Author yangbing
 * @Date 2020/9/28 1:57 下午
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(">>>AuthInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前)");

        String token = request.getHeader("token");

        log.info("token : [ {} ]", token);
        request.setAttribute("startTime", System.currentTimeMillis());


        response.setStatus(500);
        String result = "{\"code\":500}";
        responseJson(response, result);

        //....处理逻辑

        // 只有返回true才会继续向下执行，返回false取消当前请求
        return false;
    }

    /**
     * 返回JSON数据
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    private static void responseJson(HttpServletResponse response, String obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.parseObject(obj));
        writer.close();
        response.flushBuffer();
    }
}
