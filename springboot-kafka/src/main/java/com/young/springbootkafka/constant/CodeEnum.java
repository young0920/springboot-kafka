package com.young.springbootkafka.constant;

import com.young.springbootkafka.exception.BaseErrorInfoInterface;

/**
 * 枚举类异常
 * <p>
 * 00000 执行成功
 * A0001 用户端错误
 * B0001 系统执行出错
 * B0200 数据校验不通过
 * B0100 系统执行超时
 * B0300 系统资源异常
 * B0400 数据库异常
 * C0001 调用第三方服务出错
 * C0100 中间件服务出错
 * C0200 第三方系统执行超时
 * C0500 通知服务出错
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 10:00
 */
public enum CodeEnum implements BaseErrorInfoInterface {

    /**
     * 执行成功
     */
    EXECUTE_SUCCESS("00000", "执行成功"),
    /**
     * 用户端错误
     */
    CLIENT_ERROR("A0001", "用户端错误"),
    /**
     * 权限错误
     */
    AUTHOR_ERROR("A0002", "权限错误"),
    /**
     * 系统执行出错
     */
    SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错"),
    /**
     * 系统执行超时
     */
    SYSTEM_EXECUTION_TIMEOUT("B0100", "系统执行超时"),
    /**
     * 数据校验不通过
     */
    DATA_VALIDATION_FAILS("B0200", "数据校验不通过"),
    /**
     * 数据库异常
     */
    DATABASE_EXCEPTION("B0300", "数据库异常"),
    /**
     * 重复提交
     */
    SUBMIT_REPEAT("B0400", "重复提交"),
    /**
     * 没有token
     */
    NO_TOKEN("B0500", "没有token"),
    /**
     * 调用第三方服务出错
     */
    THIRD_PARTY_SERVICE_ERROR("C0001", "调用第三方服务出错"),
    /**
     * 中间件服务出错
     */
    MIDDLEWARE_SERVICE_ERROR("C0100", "中间件服务出错"),
    ;


    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    CodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }


    public static CodeEnum ofValue(String resultCode) {
        for (CodeEnum codeEnum : values()) {
            if (codeEnum.resultCode.equals(resultCode)) {
                return codeEnum;
            }
        }
        return null;
    }
}
