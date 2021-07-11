package com.hsq.dao.login;

import com.hsq.bean.User;
import com.hsq.jdbc.JDBCUtils;
import com.hsq.jdbc.SqlOperation;

import java.sql.Connection;

public class LoginDaoImp implements LonginDao {
    private static final Connection conn = JDBCUtils.getConnection();

    @Override
    public int login(User user) {
        try {
            conn.setAutoCommit(false);
            SqlOperation.loginModele(user);
            conn.commit();
            int type = SqlOperation.loginModele(user);
            return type;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
