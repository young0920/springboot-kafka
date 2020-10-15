package com.young.springbootkafka.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Users
 * @Author  yangbing
 * @Date  2020/10/15 3:53 下午
 */
@ApiModel(value="com-young-springbootkafka-pojo-Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    private Integer id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 角色
    */
    @ApiModelProperty(value="角色")
    private String role;

    private static final long serialVersionUID = 1L;
}