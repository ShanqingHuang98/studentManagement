package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.view.InformationAndAccountView;
import com.hsq.dao.UserDaoImp;

public class ManageServer {

    static void manageServer() {
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
                User user1 = InformationAndAccountView.deleteMenuView();
                flag = userDaoImp.invisible(user1);
                System.out.println(flag ? "删除成功" : "删除失败");
                break;
            case 3:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = userDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 4:
                User selectUname = InformationAndAccountView.selectMenuView();
                User selectedUser = userDaoImp.select(selectUname);
                InformationAndAccountView.printUser(selectedUser);
                break;
            default:
                break;
        }
    }
}
