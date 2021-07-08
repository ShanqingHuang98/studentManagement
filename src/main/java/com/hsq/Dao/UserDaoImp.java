package com.hsq.Dao;

import com.hsq.bean.User;
import com.hsq.Utils.JDBCUtils;

import java.sql.*;

/**
 * @author concise
 */
public class UserDaoImp implements UserDao {

    private static final String LONGINSQL = "select type from ACCOUNT where NAME =? and PASSWORD =?";
    // 插入语句需要更改，一部分在account表，一部分在infor表
    private static final String INSERTSQL =
            "insert into `ACCOUNT`(id, name, password,type ,created_at, updated_at)\n" +
                    "values (id, ?, ?,3, now(), now())";
    private static final String DELETESQL = "delete from ACCOUNT where NAME=?";
    private static final String UPDATESQL = "update ACCOUNT set PASSWORD=? where name=?";
    private static final String SELECTSQL = "select * from ACCOUNT where NAME=?";
    private static final String VERIFYSQL = "select PASSWORD from ACCOUNT where NAME =?";


    @Override
    public int login(User user) {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conn.prepareStatement(LONGINSQL);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int type = resultSet.getInt("type");
                return type;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, preparedStatement, resultSet);
        }
        return -1;
    }

    @Override
    public boolean insert(User user) {
        Connection conn = JDBCUtils.getConnection();
        if (conn != null) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(INSERTSQL);
                preparedStatement.setString(1, user.getUname());
                preparedStatement.setString(2, user.getUpass());
                int line = preparedStatement.executeUpdate();
                return line > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, null);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String uname) {
        Connection conn = JDBCUtils.getConnection();
        if (conn != null) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(DELETESQL);
                preparedStatement.setString(1, uname);
                int line = preparedStatement.executeUpdate();
                return line > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, null);
            }
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Connection conn = JDBCUtils.getConnection();
        if (conn != null) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = conn.prepareStatement(UPDATESQL);
                preparedStatement.setString(1, user.getUpass());
                preparedStatement.setString(2, user.getUname());
                int line = preparedStatement.executeUpdate();
                return line > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, null);
            }
        }
        return false;
    }

    @Override
    public User select(String uname) {
        Connection conn = JDBCUtils.getConnection();
        if (conn != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                preparedStatement = conn.prepareStatement(SELECTSQL);
                preparedStatement.setString(1, uname);
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    int id = result.getInt("ID");
                    uname = result.getString("NAME");
                    String upass = result.getString("PASSWORD");
                    int type = result.getInt("type");
                    return new User(id, uname, upass, type);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, resultSet);
            }
        }
        return null;
    }
}
