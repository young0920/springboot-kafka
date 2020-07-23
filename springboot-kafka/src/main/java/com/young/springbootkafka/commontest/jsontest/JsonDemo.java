package com.young.springbootkafka.commontest.jsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.young.springbootkafka.pojo.JsonVO;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/22 15:33
 */
public class JsonDemo {
    public static void main(String[] args) {
        JsonVO jsonVO = new JsonVO();
        jsonVO.setId("1");
        jsonVO.setUsername("young");
        jsonVO.setPassword("young");
        jsonVO.setRealname("young");

        jsonTest(jsonVO);

    }

    private static void jsonTest(JsonVO jsonVO) {
        //对象转jsonstr
        String s1 = JSON.toJSONString(jsonVO);
        System.out.println(s1);

        //jsonstr转jsonobject
        JSONObject j1 = JSON.parseObject(s1);
        System.out.println(j1);

        //jsonstr转对象
        JsonVO jsonVO1 = JSON.parseObject(s1, JsonVO.class);
        System.out.println(jsonVO1);

        //jsonstr转List对象
        s1 = "[{\"id\":\"1\",\"password\":\"young\",\"realname\":\"young\",\"username\":\"young\"}]";
        Type type = new TypeReference<List<JsonVO>>() {}.getType();
        List<JsonVO> list = JSON.parseObject(s1, type);
        System.out.println(list);

        // 对象转byte
        byte[] jsonBytes = JSON.toJSONBytes(jsonVO);
        System.out.println(Arrays.toString(jsonBytes));

        //对象转数组
        String text_beanToArray = JSON.toJSONString(jsonVO, SerializerFeature.BeanToArray);
        System.out.println(text_beanToArray);

        //JSON.parseObject(text_beanToArray, Feature.SupportArrayToBean);


    }
}
