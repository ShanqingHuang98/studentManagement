package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.InformationAndAccountView;
import com.hsq.dao.user.TeacherDaoImp;

public class TeacherServer {
    static void teacherServer() {
        TeacherDaoImp teacherDaoImp = new TeacherDaoImp();
        int teacherMenuView = InformationAndAccountView.teacherMenuView();
        boolean flag;
        switch (teacherMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = teacherDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = teacherDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 3:
                User selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = teacherDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;

        }
    }
}
