package com.hsq.view;
import java.util.Scanner;

public class GradeView {


    private static Scanner input = new Scanner(System.in);

    // 上一个表主要是增删改查account，这个主要是成绩，只有管理员和教师可以操作，管理员增删改查，教师增改查
    public static int teachergradeView() {
        System.out.println("******************************************************************");
        System.out.println("*******************\t\t 欢迎老师回家 \t\t**************************");
        System.out.println("**********************\t\t 请根据提示操作 \t\t*************************");
        System.out.println("**********************\t\t 0. 退出 \t\t***************************");
        System.out.println("**********************\t\t 1. 增加学生成绩 \t\t***************************");
        System.out.println("**********************\t\t 2. 修改学生成绩 \t\t***************************");
        System.out.println("**********************\t\t 3. 查询学生成绩 \t\t***************************");
        String type = input.nextLine();
        int ietm = Integer.parseInt(type);
        if (ietm < 0 || ietm > 3) {
            System.out.println("输入有误！请重新输入");
            return teachergradeView();
        }
        System.out.println("******************************************************************");
        return ietm;
    }
}
