package com.hsq.dao.user;

import com.hsq.bean.User;
import com.hsq.dao.login.LonginDao;
import com.hsq.jdbc.JDBCUtils;
import com.hsq.jdbc.SqlOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImp implements UserDao, LonginDao {
    private static final Connection conn = JDBCUtils.getConnection();
    private static final PreparedStatement preparedStatement = null;
    private static final ResultSet resultSet = null;

    @Override
    public int login(User user) {
        return 0;
    }

    @Override
    public boolean insert(User user) {
        try {
            conn.setAutoCommit(false);
            SqlOperation.insertToAccount(user);
            SqlOperation.insertToInfo(user);
            SqlOperation.insertToGrade(user);
            SqlOperation.addToTableLog(user);
            conn.commit();
            return true;
        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException e) {
                System.out.println("异常");
                e.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, resultSet);
            }
        }
        return false;
    }


    @Override
    public boolean invisible(User user) {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
                SqlOperation.invisInfo(user);
                SqlOperation.invisAcc(user);
                SqlOperation.invisGrade(user);
                SqlOperation.addToTableLog(user);
                conn.commit();
                return true;
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, resultSet);
            }
        }
        return false;
    }


    @Override
    public boolean update(User user) {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
                SqlOperation.updateAccPass(user);
                SqlOperation.updateGrade(user);
                SqlOperation.addToTableLog(user);
                conn.commit();
                return true;
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                JDBCUtils.close(conn, preparedStatement, resultSet);
            }
        }
        return false;
    }


    @Override
    public User select(User user) {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
                User userFromInfo = SqlOperation.selectInfo(user);
                SqlOperation.selectGrade(user);
                SqlOperation.addToTableLog(user);
                conn.commit();
                return userFromInfo;
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                System.out.println("事务回滚");
            } finally {
                JDBCUtils.close(conn, preparedStatement, resultSet);
            }
        }
        return null;
    }
}
