package com.young.springbootkafka.exception;

/**
 * 基础的接口类，自定义的错误描述枚举类需实现该接口
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 10:26
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     * @return code
     */
    String getResultCode();

    /**
     * 错误描述
     * @return msg
     */
    String getResultMsg();
}
