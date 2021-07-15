package com.hsq.client;

import com.hsq.bean.User;

import java.math.BigInteger;

import java.util.Scanner;

/**
 * @author concise
 */
public class InformationAndAccountView {

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

        User user = new User(uname, upass);
        System.out.println(user);
        return user;
    }

    // 管理员菜单
    public static int managerMenuView() {
        System.out.println("***********************************************************************");
        System.out.println("************************\t\t 欢迎管理员回家 \t\t**************************");
        System.out.println("*************************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**************************\t\t 0. 退出 \t\t*****************************");
        System.out.println("**********************\t\t 1. 增加学生信息 \t\t***************************");
        System.out.println("**********************\t\t 2. 删除学生信息 \t\t***************************");
        System.out.println("**********************\t\t 3. 修改学生信息 \t\t***************************");
        System.out.println("**********************\t\t 4. 查询学生信息 \t\t***************************");
        String type = input.nextLine();
        int item = Integer.parseInt(type);
        if (item < 0 || item > 4) {
            System.out.println("输入有误！请重新输入");
            return managerMenuView();
        }
        System.out.println("******************************************************************");
        return item;
    }

    // 教师
    public static int teacherMenuView() {
        System.out.println("***********************************************************************");
        System.out.println("*************************\t\t 欢迎老师回家 \t\t**************************");
        System.out.println("*************************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**************************\t\t 0. 退出 \t\t*****************************");
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
        System.out.println("***********************************************************************");
        System.out.println("*************************\t\t 欢迎同学回家 \t\t**************************");
        System.out.println("*************************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**************************\t\t 0. 退出 \t\t*****************************");
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
        System.out.println("**********************\t\t 请输入新添加人员类型\t\t***************************");
        int type = Integer.parseInt(input.nextLine());
        System.out.println("**********************\t\t 请输入新添加人员的性别\t\t***************************");
        String sex = input.nextLine();
        System.out.println("**********************\t\t 请输入新添加人员的学号\t\t***************************");
        BigInteger number = input.nextBigInteger();
        System.out.println("**********************\t\t 请输入新添加人员的入学年份\t\t***************************");
        Long year = input.nextLong();
        String a = input.nextLine();
        System.out.println("**********************\t\t 请输入新添加人员的学院\t\t***************************");
        String academy = input.nextLine();
        System.out.println("**********************\t\t 请输入新添加人员的专业\t\t***************************");
        String major = input.nextLine();
        System.out.println("*****************************************************************************");
        return new User(uname, upass, type, sex, number, year, academy, major);

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
        System.out.println("******x************************************************************");
        System.out.println("**********************\t\t 请根据提示操作\t\t*************************");
        System.out.println("**********************\t\t 请输入需修改的账号\t\t***************************");
        String uname = input.nextLine();
        System.out.println("**********************\t\t 请输入新的密码\t\t***************************");
        String upass = input.nextLine();
        System.out.println("******************************************************************");
        return new User(uname, upass);
    }

    /**
     * 查询学生信息视图
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


    /**
     * 输出学生信息
     *
     * @param user
     * @author concise
     */
    public static void printUser(User user) {
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getUname());
        System.out.println("password: " + user.getUpass());
        if (user.getType() == 1) {
            System.out.println("用户权限：管理员" + user.getType());
        } else if (user.getType() == 2) {
            System.out.println("用户权限：教师" + user.getType());
        } else if (user.getType() == 3) {
            System.out.println("用户权限：学生" + user.getType());
        }
    }
}
