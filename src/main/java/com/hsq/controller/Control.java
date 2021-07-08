package com.hsq.controller;

import com.hsq.Dao.UserDaoImp;
import com.hsq.bean.User;
import com.hsq.view.InformationAndAccountView;

public class Control {
    public static void main(String[] args) {

        User user = InformationAndAccountView.indexView();
        UserDaoImp userDaoImp = new UserDaoImp();
        int type = userDaoImp.login(user);
        switch (type) {
            case -1:
                System.out.println("输入有误，已退出");
                break;
            case 1:
                System.out.println("恭喜管理员登录");
                manageServer();
                break;
            case 2:
                System.out.println("恭喜老师登录");
                teacherServer();
                break;
            case 3:
                System.out.println("恭喜同学登录");
                studentServer();
                break;
            default:
                break;
        }
    }


    private static void manageServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        boolean flag;
        int managerMenuView = InformationAndAccountView.managerMenuView();
        switch (managerMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = userDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                String uname = InformationAndAccountView.deleteMenuView();
                flag = userDaoImp.delete(uname);
                System.out.println(flag ? "删除成功" : "删除失败");
                break;
            case 3:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = userDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 4:
                String selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = userDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;
        }
    }

    private static void teacherServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        int teacherMenuView = InformationAndAccountView.teacherMenuView();
        boolean flag;
        switch (teacherMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = userDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = userDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 3:
                String selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = userDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;

        }
    }


    private static void studentServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        int studentMenuView = InformationAndAccountView.studentMenuView();
        boolean flag;
        switch (studentMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = userDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = userDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 3:
                String selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = userDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;

        }

    }


}
