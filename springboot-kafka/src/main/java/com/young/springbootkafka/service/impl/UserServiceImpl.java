package com.young.springbootkafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.young.springbootkafka.mapper.UserMapper;
import com.young.springbootkafka.mapper.UsersMapper;
import com.young.springbootkafka.pojo.User;
import com.young.springbootkafka.pojo.Users;
import com.young.springbootkafka.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    private UsersMapper usersMapper;

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

        //headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("api-version", "1.0");
        //body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("roundid", "1");
        //HttpEntity
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        //post
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://xxx", requestEntity, String.class);
        System.out.println(responseEntity.getBody());


        //1.post
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user","youku1327");
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(jsonObject,httpHeaders);
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
        HttpEntity<JSONObject> httpEntity2 = new HttpEntity<>(jsonObject,httpHeaders);
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

    @Override
    public String testToken() {
        String url = "http://192.168.0.23:8675/nccloud/opm/accesstoken?biz_center=NJDT&password=KlB6h006s%2F2u9lRDvQ2LqLlQyy2w4xbkOHYbI%2Bj9jeg0Zu3XSKC4to3lIMgaA6LRgRV%2BJiLBtRQw%0D%0AWZa66CKKEMzdaXxX3%2BoMFdgbpCbZCfBNYqEwdoDqspJGxVXL9hXOuFx2YniboElKRyiKiY2ecqRO%0D%0AUdWFe6FWgh0%2Bo3uM0k0%3D%0D%0A&grant_type=password&signature=b287efa18c5cf02078c807e260dad18a97580814be8582d0bbb634ede971c981&client_secret=df%2BXx8PG9HVJhO8B1ownUz0%2Fk0ubQ6IRn%2BWpTmAAl33VHb2FSLugnpVAelw7x8%2BiSltAGVk%2BvKxt%0D%0AIHve2oVEIhLv1VfqU970%2FTYvjQWj1Gu1maQK8ZVJQzN0v0daaFxZ%2Fm3Ci9uUpL2iD7WESWzGodZ9%0D%0A51N0Ms8K0ffnM7taPy0%3D%0D%0A&client_id=wenlifeng&username=wenlifeng";
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        String token = restTemplate.postForObject(url, httpEntity, String.class);
        return token;
    }

    @Override
    public void insertToUsers(Users user) {
        user.setId(111);
        usersMapper.insert(user);
    }


}
