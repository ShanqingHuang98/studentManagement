package com.hsq.jdbc;

import com.hsq.bean.User;
import com.hsq.view.View;
import org.junit.Test;

public class ViewTest {
    // 测试登陆页
    @Test
    public void indexViewTest() throws Exception {
        User user = View.indexView();
        System.out.println(user);
    }

    // 测试管理员页面
    @Test
    public void managerMenuViewTest() throws Exception {
        int item = View.managerMenuView();
        System.out.println(item);
    }

    // 测试老师页面
    @Test
    public void teacherMenuViewTest() throws Exception {
        int item = View.teacherMenuView();
        System.out.println(item);
    }

    // 测试学生页面
    @Test
    public void studentMenuViewTest() throws Exception {
        int item = View.studentMenuView();
        System.out.println(item);
    }

    // 测试添加学生信息视图
    @Test
    public void addMenuViewTest() throws Exception {
        User user = View.addMenuView();
        System.out.println(user);
    }

    // 测试删学生信息视图
    @Test
    public void deleteMenuViewTest() throws Exception {
        User user = View.deleteMenuView();
        System.out.println(user);
    }

    // 测试改学生信息视图
    @Test
    public void changeMenuViewTest() throws Exception {
        User user = View.changeMenuView();
        System.out.println(user);
    }

    // 测试查学生信息视图
    @Test
    public void selectMenuViewTest() throws Exception {
        User user = View.selectMenuView();
        System.out.println(user);
    }
}
