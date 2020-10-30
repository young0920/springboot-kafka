package com.young.springbootkafka.commontest.xmlTest;

import com.young.springbootkafka.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Demo01JDBCUtils
 *
 * @author yangbing
 * @date 2020/10/29 8:43 下午
 */
@Slf4j
public class Demo01JDBCUtils {
    public static void main(String[] args) {
        List<User> list = findAll();
        System.out.println("list = " + list);
        System.out.println(insertUser());
    }

    public static int insertUser() {
        Connection conn = null;
        Statement st = null;
        int result = 0;
        try {
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "INSERT INTO `young`.`user`(`id`, `username`, `password`, `role`) VALUES (222, 'admin2', '$2a$10$8zYOAnaAufIoOn7v9aI95.TlAA23GUwuVNdSV1squ3C3LrRKyk7PO', 'ROLE_USER');";
            //获取执行sql的对象
            st = conn.createStatement();
            //执行sql
            result = st.executeUpdate(sql);
        } catch (SQLException e) {
            log.error("SQL inset error", e);
        } finally {
            JDBCUtils.close(null, st, conn);
        }
        return result;
    }

    //定义一个方法，查询user表的数据将其封装为对象，然后装载集合，返回。
    public static List<User> findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<User> list = null;
        try {
            conn = JDBCUtils.getConnection();
            //定义sql
            String sql = "SELECT * FROM user";
            //获取执行sql的对象
            st = conn.createStatement();
            //执行sql
            rs = st.executeQuery(sql);
            User bean = new User();
            list = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                bean = new User(id, username, password, null, new Date());
                list.add(bean);
            }
        } catch (SQLException e) {
            log.error("SQL execute error", e);
        } finally {
            JDBCUtils.close(rs, st, conn);
        }
        return list;
    }
}
