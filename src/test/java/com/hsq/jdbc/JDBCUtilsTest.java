package com.hsq.jdbc;

import com.hsq.Dao.UserDaoImp;
import com.hsq.bean.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtilsTest {

    @Test
    public void jdbcConnectionTest() throws Exception {
        // 静态方法可用类名调用
        Connection connection = JDBCUtils.getConnection();
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from INFORMATION");
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                System.out.println(id + " " + name);
            }
        }
    }

    /**
     * 测试登录
     */
    @Test
    public void longinTest() throws Exception {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User("江周简", "SEx");
        int type = userDaoImp.login(user);
        System.out.println(type);
    }


    /**
     * 测试添加用户
     */
    @Test
    public void insertTest() throws Exception {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User("donkey", "223we322");
        boolean insert = userDaoImp.insert(user);
        System.out.println(insert);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void deleteTest() throws Exception {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User("donkey", "一修改");
        boolean delete = userDaoImp.delete(user.getUname());
        System.out.println(delete);
    }

    /**
     * 测试修改用户
     */
    @Test
    public void updateTest() throws Exception {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User("donkey", "一修改");
        boolean change = userDaoImp.update(user);
        System.out.println(change);
    }

    /**
     * 测试查找用户
     */
    @Test
    public void selectTest() throws Exception {
        UserDaoImp userDaoImp = new UserDaoImp();
        User user = new User("donkey", "223we322");
        User user1 = userDaoImp.select(user.getUname());
        System.out.println(user1);
    }
}
