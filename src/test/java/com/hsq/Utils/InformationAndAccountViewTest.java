package com.hsq.Utils;

import com.hsq.bean.User;
import com.hsq.view.InformationAndAccountView;
import org.junit.Test;

public class InformationAndAccountViewTest {
    // 测试登陆页
    @Test
    public void indexViewTest() throws Exception {
        User user = InformationAndAccountView.indexView();
        System.out.println(user);
    }

    // 测试管理员页面
    @Test
    public void managerMenuViewTest() throws Exception {
        int item = InformationAndAccountView.managerMenuView();
        System.out.println(item);
    }

    // 测试老师页面
    @Test
    public void teacherMenuViewTest() throws Exception {
        int item = InformationAndAccountView.teacherMenuView();
        System.out.println(item);
    }

    // 测试学生页面
    @Test
    public void studentMenuViewTest() throws Exception {
        int item = InformationAndAccountView.studentMenuView();
        System.out.println(item);
    }

    // 测试添加学生信息视图
    @Test
    public void addMenuViewTest() throws Exception {
        User user = InformationAndAccountView.addMenuView();
        System.out.println(user);
    }

    // 测试删学生信息视图
    @Test
    public void deleteMenuViewTest() throws Exception {
        String uname = InformationAndAccountView.deleteMenuView();
        System.out.println(uname);
    }

    // 测试改学生信息视图
    @Test
    public void changeMenuViewTest() throws Exception {
        User user = InformationAndAccountView.changeMenuView();
        System.out.println(user);
    }

    // 测试查学生信息视图
    @Test
    public void selectMenuViewTest() throws Exception {
        String uname = InformationAndAccountView.selectMenuView();
        System.out.println(uname);
    }
}
