package com.young.springbootkafka.config;

import com.young.springbootkafka.component.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 输入端口号跳转index.html
 *
 * @Author yangbing
 * @Date 2020/9/27 9:53 上午
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Resource
    AuthInterceptor authInterceptor;

    /**
     * 输入ip:port 跳转指定页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //默认地址（可以是页面或后台请求接口）
        registry.addViewController("/").setViewName("forward:/index.html");
        //设置过滤优先级最高
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }


}
