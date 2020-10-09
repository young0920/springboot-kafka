package com.young.springbootkafka.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
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

    public static <T> String validEntity(T requestVO) {
        Set<ConstraintViolation<Object>> validResult = Validation.buildDefaultValidatorFactory().getValidator()
                .validate(requestVO);
        StringBuilder sb = new StringBuilder();
        if (null != validResult && !validResult.isEmpty()) {
            for (ConstraintViolation<Object> constraintViolation : validResult) {
                //这里只取了字段名，如果需要其他信息可以自己处理
                sb.append(constraintViolation.getPropertyPath().toString()).
                        append(constraintViolation.getMessage()).append(";");
            }
        }
        return sb.toString();
    }
}
