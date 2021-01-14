package com.young.springbootkafka.component;

import com.young.springbootkafka.annotation.NoRepeatSubmit;
import com.young.springbootkafka.constant.CodeEnum;
import com.young.springbootkafka.constant.GlobalConstants;
import com.young.springbootkafka.constant.ResultBody;
import com.young.springbootkafka.util.RedisUtils;
import com.young.springbootkafka.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RepeatSubmitAop
 *
 * @author yangbing
 * @date 2021/1/14 下午7:46
 */
@Aspect
@Component
@Slf4j
public class RepeatSubmitAop {

    /**
     * 注入Redis工具类
     */
    @Resource
    private RedisUtils redisUtils;

    /**
     * 定义切入点, 拦截controller的所有请求
     */
    private static final String POINTCUT = "execution(public * com.young.springbootkafka.controller.*.*(..))";


    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return object
     * @throws Throwable
     */
    @Around(POINTCUT)
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. 使用AOP环绕通知拦截所有请求(controller)
        //POINTCUT
        //2. 判断方法上是否有@NoRepeatSubmit
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        NoRepeatSubmit noRepeatSubmit = signature.getMethod().getDeclaredAnnotation(NoRepeatSubmit.class);
        //3. 如果方法上有@NoRepeatSubmit
        if (null != noRepeatSubmit) {
            //获取type参数的value
            String typeValue = noRepeatSubmit.type();
            HttpServletRequest request = getRequest();
            if (request == null) {
                log.error("request is null");
                return null;
            }
            String token;
            //如果存在header中,从头中获取
            if (StringUtils.equals(typeValue, GlobalConstants.API_HEADER)) {
                token = request.getHeader("token");
            } else {
                //否则从 请求参数获取
                token = request.getParameter("token");
            }
            HttpServletResponse response = getResponse();
            if (response == null) {
                log.error("response is null");
                return null;
            }
            if (StringUtils.isEmpty(token)) {
                ResponseUtils.responseJson(response, ResultBody.error(CodeEnum.NO_TOKEN));
                return null;
            }
            //如果redis中token不存在，则为重复提交
            String redisToken = (String) redisUtils.get(token);
            if (StringUtils.isEmpty(redisToken)) {
                ResponseUtils.responseJson(response, ResultBody.error(CodeEnum.SUBMIT_REPEAT));
                return null;
            }
            //redis不为空，则为第一次请求
            redisUtils.del(redisToken);
        }
        //放行
        return joinPoint.proceed();
    }

    /**
     * 获取当前请求的HttpServletRequest对象
     *
     * @return request
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getRequest();
    }

    /**
     * 获取当前请求的HttpServletResponse对象
     *
     * @return response
     */
    private HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getResponse();
    }
}