package com.young.springbootkafka.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * BindingResultUtils
 *
 * @Author yangbing
 * @Date 2020/9/29 7:00 下午
 */
@Slf4j
public class BindingResultUtils {

    private BindingResultUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 获取必填项校验结果
     *
     * @param bindingResult 结果集
     * @return sb
     */
    public static String getBindingMessage(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        fieldErrors.forEach(fieldError -> {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            log.error("error field is : {} ,message is : {}", field, defaultMessage);
            sb.append(field).append(":").append(defaultMessage).append(";");
        });
        return sb.toString();
    }

    /**
     * 校验实体类字段
     * @param entity 对象
     * @param <T>
     * @return 错误信息
     */
    public static <T> String validEntity(T entity) {
        Set<ConstraintViolation<T>> validate = validator.validate(entity);
        StringBuilder sb = new StringBuilder();
        if (validate != null && !validate.isEmpty()) {
            for (ConstraintViolation<T> constraintViolation : validate) {
                sb.append(constraintViolation.getPropertyPath().toString()).append(":")
                        .append(constraintViolation.getMessage()).append("; ");
            }
        }
        return sb.toString();
    }
}
