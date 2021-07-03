package com.hsq.view;

import com.hsq.bean.User;

import java.util.Scanner;

/**
 * @author concise
 */
public class View {

    private static Scanner input = new Scanner(System.in);

    // 首页
    public static User indexView() {
        System.out.println("******************************************************************");
        System.out.println("*******************\t\t 学生信息管理系统\t\t**************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 请输入密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");
        System.out.println("******************************************************************");

        return new User(uname, upass);

    }

    // 管理员菜单
    public static int managerMenuView() {
        System.out.println("******************************************************************");
        System.out.println("*******************\t\t 欢迎管理员回家 \t\t**************************");
        System.out.println("**********************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**********************\t\t 0. 退出 \t\t***************************");
        System.out.println("**********************\t\t 1. 增加学生信息 \t\t***************************");
        System.out.println("**********************\t\t 2. 删除学生信息 \t\t***************************");
        System.out.println("**********************\t\t 3. 修改学生信息 \t\t***************************");
        System.out.println("**********************\t\t 4. 查询学生信息 \t\t***************************");
        String type = input.nextLine();
        int ietm = Integer.parseInt(type);
        if (ietm < 0 || ietm > 4) {
            System.out.println("输入有误！请重新输入");
            return managerMenuView();
        }
        System.out.println("******************************************************************");
        return ietm;
    }

    // 教师
    public static int teacherMenuView() {
        System.out.println("******************************************************************");
        System.out.println("*******************\t\t 欢迎老师回家 \t\t**************************");
        System.out.println("**********************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**********************\t\t 0. 退出 \t\t***************************");
        System.out.println("**********************\t\t 1. 增加学生信息 \t\t***************************");
        System.out.println("**********************\t\t 2. 修改学生信息 \t\t***************************");
        System.out.println("**********************\t\t 3. 查询学生信息 \t\t***************************");
        String type = input.nextLine();
        int ietm = Integer.parseInt(type);
        if (ietm < 0 || ietm > 3) {
            System.out.println("输入有误！请重新输入");
            return teacherMenuView();
        }
        System.out.println("******************************************************************");
        return ietm;
    }

    public static int studentMenuView() {
        System.out.println("******************************************************************");
        System.out.println("*******************\t\t 欢迎同学回家 \t\t**************************");
        System.out.println("**********************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**********************\t\t 0. 退出 \t\t***************************");
        System.out.println("**********************\t\t 1. 增加学生信息 \t\t***************************");
        System.out.println("**********************\t\t 2. 修改学生信息 \t\t***************************");
        System.out.println("**********************\t\t 3. 查询学生信息 \t\t***************************");
        String type = input.nextLine();
        int ietm = Integer.parseInt(type);
        if (ietm < 0 || ietm > 3) {
            System.out.println("输入有误！请重新输入");
            return studentMenuView();
        }
        System.out.println("******************************************************************");
        return ietm;
    }

    /**
     * 添加学生信息视图
     *
     * @return new User object
     */
    public static User addMenuView() {
        System.out.println("******************************************************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入新添加的账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 请输入新添加的密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");

        return new User(uname, upass);
    }

    /**
     * 删除学生信息视图
     *
     * @return new User object
     */
    public static User deleteMenuView() {
        System.out.println("******************************************************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入需删除的账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 删除账号需要确认密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");

        return new User(uname, upass);
    }

    /**
     * 修改学生信息视图
     *
     * @return new User object
     */
    public static User changeMenuView() {
        System.out.println("******************************************************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入需修改的账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 修改账号需要确认密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");

        return new User(uname, upass);
    }

    /**
     * 修改学生信息视图
     *
     * @return new User object
     */
    public static User selectMenuView() {
        System.out.println("******************************************************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入需查询的账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 查询账号需要确认密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");

        return new User(uname, upass);
    }
}
