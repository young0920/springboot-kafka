package com.young.springbootkafka.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
