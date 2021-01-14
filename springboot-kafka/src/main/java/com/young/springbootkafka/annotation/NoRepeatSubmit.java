package com.young.springbootkafka.annotation;

import java.lang.annotation.*;

/**
 * 对解决接口幂等性、网络延迟、表单重复提交的注解的封装
 *
 * @author yangbing
 * @date 2021/1/14 下午7:56
 */
@Documented
@Inherited
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRepeatSubmit {
    String type() default "";
}
