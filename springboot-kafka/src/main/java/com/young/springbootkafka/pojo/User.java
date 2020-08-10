package com.young.springbootkafka.pojo;

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
*  User实体类  实现序列化  不然redis报错
 * @author yangbing
 * @date  2020/7/6 11:53
 * @version 1.0
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User implements Serializable {
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

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date time;
}