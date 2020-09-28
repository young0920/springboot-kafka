package com.young.springbootkafka.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器配置(只能处理request中的数据  不能确定请求要走的是哪个controller信息)
 * Filter 是javax.servlet下的
 * 让自定义filter起作用，只需要让springcontext管理起来即可
 *
 * @Author yangbing
 * @Date 2020/9/28 2:23 下午
 */
//@Component
@Slf4j
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("AuthFilter filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("AuthFilter filter start");

        //获取token
        String token = ((RequestFacade) request).getHeader("token");
        //获取权限代码
        String authorization = ((RequestFacade) request).getHeader("Authorization");

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        log.info("AuthFilter filter destroy");
    }
}
