package com.young.springbootkafka.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.young.springbootkafka.util.BindingResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * JacaTest
 *
 * @Author yangbing
 * @Date 2020/9/8 2:08 下午
 */
public class JacaTest {
    public static void main(String[] args) {

        //test1();

        //test2();

//        User u1 = new User();
//        u1.setId("222");
//        u1.setUsername("33");
//        u1.setPassword("33");
//        u1.setRealname("33");
//        u1.setTime(new Date());
//
//        String s = JSON.toJSONString(u1);
//        Test user2 = JSON.parseObject(s, Test.class);
//        System.out.println(user2);

        User2 u = new User2();
        u.setPassword("111111111111111111111111");
        u.setRealname("zhan");
        Users users = new Users();
        u.setUsers(users);

        List<Users> usersList = new ArrayList<>();
        usersList.add(users);
        u.setUsersValidList(usersList);

        String bindingMessage = BindingResultUtils.validEntity(u);
        if(StringUtils.isNotBlank(bindingMessage)){
            System.out.println(bindingMessage);
        }

    }

    private static void test2() {
        User u1 = new User();
        u1.setId("222");
        u1.setUsername("33");
        u1.setPassword("33");
        u1.setRealname("33");
        u1.setTime(new Date());

        User2 user2 = new User2();

        BeanUtils.copyProperties(u1,user2);

        System.out.println(user2);
    }

    private static void test1() {
        System.out.println(new Date());

        String s = "{\n" +
                "\t\"msgId\": \"CG.HT.01-uuid \",\n" +
                "\t\"msgTime\":\"2020-05-09 12:10:12\",\n" +
                "\t\"appId\": \"cgxt\",\n" +
                "\t\"msgStatus \":\"0\",\n" +
                "\t\"returnDescription \":\"成功\",\n" +
                "\t\"msgData\": [{\n" +
                "\t\t\"id\":\"1\",\n" +
                "\"username\":\"张三\",\n" +
                "\"usern\":\"zhansan\"\n" +
                "\t},\n" +
                "{\n" +
                "\t\t\"id\":\"1\",\n" +
                "\"us\":\"张三\",\n" +
                "\"usern\":\"zhansan\"\n" +
                "\t}]\n" +
                "\t}";

        JSONObject j1 = JSONObject.parseObject(s);
        JSONArray msgData = j1.getJSONArray("msgData");
        List<User> msgData1 = JSON.parseArray(j1.getString("msgData"), User.class);
        for (User user : msgData1) {
            System.out.println(user);
        }
    }


}
