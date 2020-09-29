package com.young.springbootkafka.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * BindingResultUtils
 *
 * @Author yangbing
 * @Date 2020/9/29 7:00 下午
 */
@Slf4j
public class BindingResultUtils {

    /**
     * 获取必填项校验结果
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
}
