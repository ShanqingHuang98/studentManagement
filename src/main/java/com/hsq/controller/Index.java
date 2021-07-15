package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.InformationAndAccountView;
import com.hsq.dao.login.LoginDaoImp;


public class Index {
    static void index() {
        User user = InformationAndAccountView.indexView();
        LoginDaoImp loginDaoImp = new LoginDaoImp();
        int type = loginDaoImp.login(user);
        switch (type) {
            case -1:
                System.out.println("输入有误，已退出");
                break;
            case 1:
                System.out.println("恭喜管理员登录");
                ManageServer.manageServer();
                break;
            case 2:
                System.out.println("恭喜老师登录");
                TeacherServer.teacherServer();
                break;
            case 3:
                System.out.println("恭喜同学登录");
                StuServer.studentServer();
                break;
            default:
                break;
        }
    }
}