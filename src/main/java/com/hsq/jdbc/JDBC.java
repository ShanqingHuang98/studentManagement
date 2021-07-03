package com.hsq.jdbc;


import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 加载数据库，获得连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studb", "root", "123456");
            // 创建执行环境
            String sql = "select * from INFORMATION ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            // 查询有query，删除update
            // 执行sql语句，得到返回结果集
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                System.out.println(id + " " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
