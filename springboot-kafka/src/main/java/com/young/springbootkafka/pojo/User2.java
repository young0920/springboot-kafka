package com.young.springbootkafka.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.young.springbootkafka.annotation.MyConstraint;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User实体类  实现序列化  不然redis报错
 * //被注释的元素必须为null
 *
 * @author yangbing
 * @version 1.0
 * @Null //被注释的元素不能为null
 * @NotNull //被注释的元素必须为true
 * @AssertTrue //被注释的元素必须为false
 * @AssertFalse //被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Min(value) //被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Max(value) //被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMin(value) //被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMax(value) //被注释的元素的大小必须在指定的范围内。
 * @Size(max,min) //被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Digits(integer,fraction) //被注释的元素必须是一个过去的日期
 * @Past //被注释的元素必须是一个将来的日期
 * @Future //被注释的元素必须符合指定的正则表达式。
 * @Pattern(value) //被注释的元素必须是电子邮件地址
 * @Email //被注释的字符串的大小必须在指定的范围内
 * @Length //被注释的字符串必须非空
 * @NotEmpty //被注释的元素必须在合适的范围内
 * @Range
 * @date 2020/7/6 11:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User2 implements Serializable {
    /**
     * id @JsonProperty(value= "")
     */
    @ApiModelProperty(value = "用户id")
    private String id;

    /**
     * 用户名字
     */
    @JSONField(alternateNames = "us")
    @ApiModelProperty(value = "用户名字")
    //@NotBlank(message = "姓名不能为空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @JSONField(alternateNames = "pass")
    @NotBlank(message = "密码不能为空")
    @Size(max = 10, message = "密码的长度不能超过10")
    private String password;

    /**
     * 真名
     */
    @ApiModelProperty(value = "真名")
    @MyConstraint(message = "真名不能为空且长度小于5")
    private String realname;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//出参格式化
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")//入参格式化
    private Date time;

    @Valid
    @NotNull(message = "users对象不能为空")
    private Users users;

    @Valid
    @NotEmpty(message = "usersValidList不能为空")
    private List<Users> usersValidList;

}