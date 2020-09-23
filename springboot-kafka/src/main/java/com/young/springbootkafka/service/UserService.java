package com.young.springbootkafka.service;

import com.young.springbootkafka.pojo.User;

import java.util.List;

/**
 * UserService
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/6 13:10
 */
public interface UserService {
    /**
     * 批量新增
     *
     * @param userList
     * @return
     */
    int insertBatchUser(List<User> userList);

    /**
     * 批量修改
     *
     * @param userList
     * @return
     */
    int updateBatchUser(List<User> userList);

    /**
     * 批量查询
     *
     * @param idList
     * @return
     */
    List<User> selectBatchUser(List<String> idList);

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    int deleteBatchUser(List<String> idList);

    /**
     * 测试RestTemplate
     */
    void testRestTemplate();

    List<User> testPageHelper();

    String testToken();
}
