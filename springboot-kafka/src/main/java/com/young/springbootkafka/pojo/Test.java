package com.young.springbootkafka.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 测试类
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 15:42
 */
@ApiModel(value = "com-young-springbootkafka-pojo-Test")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

}