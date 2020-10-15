package com.young.springbootkafka.mapper;

import com.young.springbootkafka.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UsersMapper
 * @Author  yangbing
 * @Date  2020/10/15 3:53 下午
 */
@Mapper
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int updateBatch(List<Users> list);

    int updateBatchSelective(List<Users> list);

    int batchInsert(@Param("list") List<Users> list);

    Users findByUsername(@Param("username")String username);


}