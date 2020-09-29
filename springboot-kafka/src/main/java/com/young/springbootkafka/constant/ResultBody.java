package com.young.springbootkafka.constant;

import com.alibaba.fastjson.JSON;
import com.young.springbootkafka.exception.BaseErrorInfoInterface;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回格式
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 9:44
 */
@Data
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T data;

    public ResultBody() {
    }

    public ResultBody(BaseErrorInfoInterface errorInfo, T data) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
        this.data = data;
    }

    private ResultBody(T data) {
        this.code = CodeEnum.SUCCESS.getResultCode();
        this.message = CodeEnum.SUCCESS.getResultMsg();
        this.data = data;
    }

    private ResultBody(String code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody<String> success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<>(data);
    }

    /**
     * 失败
     */
    public static ResultBody<String> error(BaseErrorInfoInterface errorInfo) {
        return new ResultBody<>(errorInfo, null);
    }

    /**
     * 失败
     */
    public static ResultBody<String> error(String code, String message) {
        return new ResultBody<>(code, message);
    }

    public static <T> ResultBody<T> error(BaseErrorInfoInterface errorInfo, T data) {
        return new ResultBody<>(errorInfo, data);
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
