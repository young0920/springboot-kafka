package com.young.springbootkafka.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * fastJson
 * <p>
 * name 指定字段的名称
 * ordinal 配置序列化和反序列化的顺序，1.1.42版本之后才支持
 * format 指定字段的格式，对日期格式有用
 * serialize 是否序列化
 * deserialize 是否反序列化
 * alternateNames 使用多个不同的字段名称
 * jsonDirect 当你有一个字段是字符串类型，里面是json格式数据，你希望直接输入，而不是经过转义之后再输出。
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/22 15:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class JsonVO {
    /**
     * id
     */
    @ApiModelProperty(value = "用户id")
    private String id;

    /**
     * 用户名字
     */
    @ApiModelProperty(value = "用户名字")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 真名
     */
    @ApiModelProperty(value = "真名")
    private String realname;
}
