package com.hsq.jdbc;


import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 加载数据库，获得连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb", "root", "123456");
            // 创建执行环境
            PreparedStatement preparedStatement = (PreparedStatement) conn.createStatement();
            // 查询有query，删除update
            // 执行sql语句，得到返回结果集
            ResultSet resultSet = preparedStatement.executeQuery("select * from ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
