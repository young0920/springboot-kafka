package com.young.springbootkafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.young.springbootkafka.mapper.UserMapper;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
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
    @Resource
    private UserMapper userMapper;

    @Resource
    private RestTemplate restTemplate;

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

    @Override
    public void testRestTemplate() {
        //1.post
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user","youku1327");
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);
        String url = "http://localhost:8090/youku1327/provider";
        ResponseEntity<String> mapResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        System.out.println(mapResponseEntity.getBody());

        //2.get
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("user","youku1327");
        HttpHeaders httpHeaders2 = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity2 = new HttpEntity(jsonObject,httpHeaders);
        String url2 = "http://localhost:8090/youku1327/provider/{id}";
        restTemplate.put(url2, httpEntity2, 1327);

        //3.delete
        String url3 = "http://localhost:8090/youku1327/provider/{id}";
        restTemplate.delete(url3,1327);

        //4.exchange
        String url4 = "http://localhost:8090/youku1327/user/{name}";
        HttpHeaders httpHeaders4 = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity httpEntity4 = new HttpEntity(httpHeaders4);
        ResponseEntity<String> exchange = restTemplate.exchange(url4, HttpMethod.GET, httpEntity4, String.class, "youku1327");
        System.out.println(exchange.getBody());
    }

    @Override
    public List<User> testPageHelper() {
        return userMapper.testPageHelper();
    }
}
