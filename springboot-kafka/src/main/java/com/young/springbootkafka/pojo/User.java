package com.young.springbootkafka.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
*  User实体类
 * @author yangbing
 * @date  2020/7/6 11:53
 * @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User {
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