package com.young.springbootkafka.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//出参格式化
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")//入参格式化
    private Date time1;

    @JSONField(format = "yyy-MM-dd HH:mm:ss")//可以换换时间戳
    private Date time2;

    private Date time3;

}