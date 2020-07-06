package com.young.springbootkafka.mapper;

import com.young.springbootkafka.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口方法
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 11:53
 */
public interface UserMapper {
    int deleteByPrimaryKey(@Param("id") String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertBatchUser(List<User> userList);

    int updateBatchUser(List<User> userList);

    List<User> selectBatchByIdList(List<String> idList);

    int deleteBatchUser(List<String> idList);
}