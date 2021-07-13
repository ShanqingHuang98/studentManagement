package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.InformationAndAccountView;
import com.hsq.dao.user.StuDaoImp;

public class StuServer {
    static void studentServer() {
        StuDaoImp stuDaoImp = new StuDaoImp();
        int studentMenuView = InformationAndAccountView.studentMenuView();
        boolean flag;
        switch (studentMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = stuDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = stuDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 3:
                User selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = stuDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;

        }

    }
}
