package com.young.springbootkafka.annotation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * MyConstraintValidator 校验规则
 *
 * @author yangbing
 * @date 2020/12/23 上午10:36
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {


    /**
     * 初始化自定义注解
     *
     * @param constraintAnnotation 注解接口
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        log.info("my validator init");
    }

    /**
     * 是否满足要求
     *
     * @param o       值
     * @param context context
     * @return boolean
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        String val = (String) o;
        return StringUtils.isNotBlank(val) && val.length() > 5;
    }

}
