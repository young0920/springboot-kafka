package com.young.springbootkafka.mapper;

import com.young.springbootkafka.pojo.Test;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 15:42
 */
public interface TestMapper {
    int deleteByPrimaryKey(String id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}