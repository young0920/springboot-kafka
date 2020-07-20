package com.young.springbootkafka.commontest.sort;

import com.young.springbootkafka.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 类注释
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/20 20:49
 */
public class CollectionSort {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i + 2));
            user.setUsername("young" + i);
            user.setPassword("young" + i);
            user.setRealname("young" + i);
            userList.add(user);
        }
        collectionSort(userList);
        System.out.println(userList);
    }
    public  static void collectionSort(List<User> list){
        //正序
        list.sort(Comparator.comparing(User::getUsername));
        //倒序
        list.sort((o1, o2) -> o2.getUsername().compareTo(o1.getUsername()));
    }
}
