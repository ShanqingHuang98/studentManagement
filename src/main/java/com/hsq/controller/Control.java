package com.hsq.controller;

import com.hsq.Dao.UserDaoImp;
import com.hsq.bean.User;
import com.hsq.view.View;

public class Control {
    public static void main(String[] args) {
        while (true) {
            User user = View.indexView();
            UserDaoImp userDaoImp = new UserDaoImp();
            int type = userDaoImp.login(user);
            switch (type) {
                case -1:
                    System.out.println("输入有误，请重新输入");
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
    }

    private static void manageServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        boolean flag;
        while (true) {
            int managerMenuView = View.managerMenuView();
            switch (managerMenuView) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    User user = View.addMenuView();
                    flag = userDaoImp.insert(user);
                    System.out.println(flag ? "添加成功" : "添加失败");
                    break;
                case 2:
                    String uname = View.deleteMenuView();
                    flag = userDaoImp.delete(uname);
                    System.out.println(flag ? "删除成功" : "删除失败");
                    break;
                case 3:
                    User updateUser = View.changeMenuView();
                    flag = userDaoImp.update(updateUser);
                    System.out.println(flag ? "修改成功" : "修改失败");
                    break;
                case 4:
                    String selectUname = View.selectMenuView();
                    User selectedUser = userDaoImp.select(selectUname);
                    View.printUser(selectedUser);
                    break;
                default:
                    break;
            }
        }

    }

    private static void teacherServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        boolean flag;
        while (true) {
            int managerMenuView = View.managerMenuView();
            switch (managerMenuView) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    User user = View.addMenuView();
                    flag = userDaoImp.insert(user);
                    System.out.println(flag ? "添加成功" : "添加失败");
                    break;
                case 2:
                    User updateUser = View.changeMenuView();
                    flag = userDaoImp.update(updateUser);
                    System.out.println(flag ? "修改成功" : "修改失败");
                    break;
                case 3:
                    String selectUname = View.selectMenuView();
                    User selectedUser = userDaoImp.select(selectUname);
                    View.printUser(selectedUser);
                    break;
                default:
                    break;
            }
        }
    }

    private static void studentServer() {
        UserDaoImp userDaoImp = new UserDaoImp();
        boolean flag;
        while (true) {
            int managerMenuView = View.managerMenuView();
            switch (managerMenuView) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    User user = View.addMenuView();
                    flag = userDaoImp.insert(user);
                    System.out.println(flag ? "添加成功" : "添加失败");
                    break;
                case 2:
                    User updateUser = View.changeMenuView();
                    flag = userDaoImp.update(updateUser);
                    System.out.println(flag ? "修改成功" : "修改失败");
                    break;
                case 3:
                    String selectUname = View.selectMenuView();
                    User selectedUser = userDaoImp.select(selectUname);
                    View.printUser(selectedUser);
                    break;
                default:
                    break;
            }
        }
    }

}
