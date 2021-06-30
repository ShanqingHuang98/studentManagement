package com.hsq.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtilsTest {

    @Test
    public void jdbcConnectionTest() throws Exception {
        // 静态方法可用类名调用
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from INFORMATION");
        while (resultSet.next()){
            Integer id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            System.out.println(id + " " + name);
        }
    }
}
