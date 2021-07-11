package com.hsq.jdbc;

import com.hsq.bean.User;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author concise
 */
public class SqlOperation {
    private static Connection conn = JDBCUtils.getConnection();

    /**
     * login
     */
    public static int loginModele(User user) throws Exception {
        String LONGINSQL = "select type from ACCOUNT where NAME =? and PASSWORD =?";
        if (conn != null) {
            PreparedStatement preparedStatement = conn.prepareStatement(LONGINSQL);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int type = resultSet.getInt("type");
                return type;
            }
        }
        return -1;
    }


    /**
     * Infomation
     *
     * @param user
     */
    public static boolean insertToInfo(User user) {
        String INSERIFOSQL = "insert into INFORMATION(id, name, type, sex, number, major, class, academy, year, created_at, updated_at)\n" +
                "    value (id, ?, 3, ?, ?, ?, ?, ?, ?, now(), now())";
        if (conn != null) {
            try {
                PreparedStatement preparedStatement1;
                preparedStatement1 = conn.prepareStatement(INSERIFOSQL);
                preparedStatement1.setString(1, user.getUname());
                preparedStatement1.setString(2, user.getSex());
                preparedStatement1.setObject(3, user.getNumber());
                preparedStatement1.setString(4, user.getMajor());
                preparedStatement1.setInt(5, user.getKlass());
                preparedStatement1.setString(6, user.getAcademy());
                preparedStatement1.setLong(7, user.getYear());
                int info = preparedStatement1.executeUpdate();
                return info > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static boolean invisInfo(User user) {
        String DELETESQL = "update INFORMATION set deleted=1 where name=?";
        if (conn != null) {
            try {
                PreparedStatement preparedStatement1;
                preparedStatement1 = conn.prepareStatement(DELETESQL);
                preparedStatement1.setString(1, user.getUname());
                int info = preparedStatement1.executeUpdate();
                return info > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public static User selectInfo(User user) throws Exception {
        String SELECTACCSQL = "select * from INFORMATION where deleted=0 and NAME=?";
        if (conn != null) {
            PreparedStatement preparedStatement1;
            preparedStatement1 = conn.prepareStatement(SELECTACCSQL);
            preparedStatement1.setString(1, user.getUname());
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String uname = result.getString("NAME");
                String sex = result.getString("SEX");
                int type = result.getInt("type");
                BigInteger number = (BigInteger) result.getObject("NUMBER");
                String major = result.getString("MAJOR");
                String academy = result.getString("ACADEMY");
                int klass = result.getInt("CLASS");
                int year = result.getInt("YEAR");
                return new User(id, uname, sex, type, number, major, academy, klass, year);
            }
        }
        return user;
    }

    /**
     * Account
     */

    public static void insertToAccount(User user) throws Exception {
        String INSERTACCSQL =
                "insert into `ACCOUNT`(id, name, password,type ,created_at, updated_at)\n" +
                        "values (id, ?,? ,3, now(), now())";
        if (conn != null) {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERTACCSQL);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
            int info = preparedStatement.executeUpdate();
            System.out.println(info);
        }
    }

    public static boolean invisAcc(User user) throws Exception {
        String DELETEACCSQL = "update ACCOUNT set deleted=1 where name=?";
        if (conn != null) {
            PreparedStatement preparedStatement1;
            preparedStatement1 = conn.prepareStatement(DELETEACCSQL);
            preparedStatement1.setString(1, user.getUname());
            int info = preparedStatement1.executeUpdate();
            return info > 0;
        }
        return false;
    }


    public static boolean updateAccPass(User user) throws Exception {
        String UPDATEPassSQL = "update ACCOUNT set PASSWORD=? where name=?";
        if (conn != null) {
            PreparedStatement preparedStatement1;
            preparedStatement1 = conn.prepareStatement(UPDATEPassSQL);
            preparedStatement1.setString(1, user.getUpass());
            preparedStatement1.setString(2, user.getUname());

            int info = preparedStatement1.executeUpdate();
            return info > 0;
        }
        return false;
    }

    public static User selectAcc(User user) throws Exception {
        String SELECTACCSQL = "select (ID,NAME,NUMBER,TYPE) from ACCOUNT where NAME = ?";
        if (conn != null) {
            PreparedStatement preparedStatement1;
            preparedStatement1 = conn.prepareStatement(SELECTACCSQL);
            preparedStatement1.setString(1, user.getUname());
            ResultSet result = preparedStatement1.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String uname = result.getString("NAME");
                int type = result.getInt("type");
                BigInteger number = (BigInteger) result.getObject("NUMBER");
                return new User(id, uname, type, number);
            }
        }
        return null;
    }


    /**
     * Grade(先不做)
     */
    public static void insertToGrade(User user) throws Exception {
//        String INSERTGRADESQL = "";
//
//        if (conn != null) {
//            PreparedStatement preparedStatement = conn.prepareStatement(INSERTGRADESQL);
//            preparedStatement.setString(1, user.getUname());
//            preparedStatement.setString(2, user.getUpass());
//            int info = preparedStatement.executeUpdate();
//            System.out.println(info);
//        }
    }

    public static void invisGrade(User user) throws Exception {
//        String DELETEACCSQL = "update ACCOUNT set deleted=1 where name=?";
//        if (conn != null) {
//            PreparedStatement preparedStatement1;
//            preparedStatement1 = conn.prepareStatement(DELETEACCSQL);
//            preparedStatement1.setString(1, uname);
//            int info = preparedStatement1.executeUpdate();
//            System.out.println(info);
//        }
    }


    public static void updateGrade(User user) throws Exception {
//        String UPDATEPassSQL = "update ACCOUNT set PASSWORD=? where name=?";
//        if (conn != null) {
//            PreparedStatement preparedStatement1;
//            preparedStatement1 = conn.prepareStatement(UPDATEPassSQL);
//            preparedStatement1.setString(1, user.getUname());
//            int info = preparedStatement1.executeUpdate();
//            System.out.println(info);
//        }
    }

    public static void selectGrade(User user) throws Exception {
        // 应该后期要改成不能select密码出来
//        String SELECTACCSQL = "select * from ACCOUNT where NAME=?";
//        if (conn != null) {
//            PreparedStatement preparedStatement1;
//            preparedStatement1 = conn.prepareStatement(SELECTACCSQL);
//            preparedStatement1.setString(1, user.getUname());
//            int info = preparedStatement1.executeUpdate();
//            System.out.println(info);
//        }
    }

    /**
     * Log
     */
    public static boolean addToTableLog(User user) throws Exception {
        String LOGSQL = "insert into LOG(id, name, number, behavior, type, created_at, updated_at)\n" +
                "VALUES (ID, ?, ?, ?, ?, now(), now());";
        if (conn != null) {
            PreparedStatement preparedStatement1;
            preparedStatement1 = conn.prepareStatement(LOGSQL);
            preparedStatement1.setString(1, user.getUname());
            preparedStatement1.setObject(2, user.getNumber());
            String behavior = "未知";
            preparedStatement1.setString(3, behavior);
            //behavior 统一先不管
            // type，从login里面拿
            int type = loginModele(user);
            preparedStatement1.setInt(4, type);
            // behavior，要看调用了什么方法才能写
            int info = preparedStatement1.executeUpdate();
            return info > 0;
        }
        return false;
    }


}


