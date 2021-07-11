package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.view.InformationAndAccountView;
import com.hsq.dao.UserDaoImp;

public class StuServer {
    static void studentServer() {
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
                User selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = userDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;

        }

    }
}
