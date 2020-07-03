package com.young.springbootkafka.dao;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserDAO
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/3 11:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
