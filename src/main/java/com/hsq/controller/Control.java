package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.view.InformationAndAccountView;
import com.hsq.dao.UserDaoImp;
import com.hsq.jdbc.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Control {
    public static void main(String[] args) throws Exception {
/**
 * 伪代码
 *         connect();
 *         login();+switchtype;
 *         close();
 */
        JDBCUtils.getConnection();
        Index.index();

        //close肯定还需要改
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        JDBCUtils.close(connection, preparedStatement, resultSet);

//        User user = InformationAndAccountView.indexView();
//        UserDaoImp userDaoImp = new UserDaoImp();
//        int type = userDaoImp.login(user);
//        switch (type) {
//            case -1:
//                System.out.println("输入有误，已退出");
//                break;
//            case 1:
//                System.out.println("恭喜管理员登录");
//                ManageServer.manageServer();
//                break;
//            case 2:
//                System.out.println("恭喜老师登录");
//                TeacherServer.teacherServer();
//                break;
//            case 3:
//                System.out.println("恭喜同学登录");
//                StuServer.studentServer();
//                break;
//            default:
//                break;
//        }
    }
}
