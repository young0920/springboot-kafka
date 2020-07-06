package com.young.springbootkafka.service.impl;

import com.young.springbootkafka.mapper.UserMapper;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 13:11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;

    @Override
    public int insertBatchUser(List<User> userList) {
        return userMapper.insertBatchUser(userList);
    }

    @Override
    public int updateBatchUser(List<User> userList) {
        return userMapper.updateBatchUser(userList);
    }

    @Override
    public List<User> selectBatchUser(List<String> idList) {
        return userMapper.selectBatchByIdList(idList);
    }

    @Override
    public int deleteBatchUser(List<String> idList) {
        return userMapper.deleteBatchUser(idList);
    }
}
