//package com.hsq.jdbc;
//
//import com.hsq.dao.UserDaoImp;
//import com.hsq.bean.User;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBCUtilsTest {
//
//    @Test
//    public void jdbcConnectionTest() throws SQLException {
//        // 静态方法可用类名调用
//        Connection connection = JDBCUtils.getConnection();
//        if (connection != null) {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from INFORMATION");
//            while (resultSet.next()) {
//                Integer id = resultSet.getInt("ID");
//                String name = resultSet.getString("NAME");
//                System.out.println(id + " " + name);
//            }
//        }
//    }
//
//    @Test
//    public void longinTest() throws Exception {
//        UserDaoImp userDaoImp = new UserDaoImp();
//        User user = new User("江周简", "SEx");
//        int type = userDaoImp.login(user);
//        System.out.println(type);
//    }
//
//    @Test
//    public void insertTest() throws Exception {
//        UserDaoImp userDaoImp = new UserDaoImp();
//        User user = new User("donkey", "223we322");
//        boolean insert = userDaoImp.insert(user);
//        System.out.println(insert);
//    }
//
//    @Test
//    public void deleteTest() throws Exception {
//        UserDaoImp userDaoImp = new UserDaoImp();
//        User user = new User("donkey", "一修改");
//        boolean delete = userDaoImp.invisible(user.getUname());
//        System.out.println(delete);
//    }
//
//
//    @Test
//    public void updateTest() throws Exception {
//        UserDaoImp userDaoImp = new UserDaoImp();
//        User user = new User("donkey", "一修改");
//        boolean change = userDaoImp.updatePassword(user);
//        System.out.println(change);
//    }
//
//
//    @Test
//    public void selectTest() throws Exception {
//        UserDaoImp userDaoImp = new UserDaoImp();
//        User user = new User("donkey", "223we322");
//        User user1 = userDaoImp.select(user);
//        System.out.println(user1);
//    }
//}
