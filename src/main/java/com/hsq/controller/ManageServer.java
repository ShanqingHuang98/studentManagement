package com.hsq.controller;

import com.hsq.bean.User;
import com.hsq.client.InformationAndAccountView;
import com.hsq.dao.user.ManagerDaoImp;

public class ManageServer {

    static void manageServer() {
        ManagerDaoImp managerDaoImp = new ManagerDaoImp();
        boolean flag;
        int managerMenuView = InformationAndAccountView.managerMenuView();
        switch (managerMenuView) {
            case 0:
                System.exit(-1);
                break;
            case 1:
                User user = InformationAndAccountView.addMenuView();
                flag = managerDaoImp.insert(user);
                System.out.println(flag ? "添加成功" : "添加失败");
                break;
            case 2:
                User user1 = InformationAndAccountView.deleteMenuView();
                flag = managerDaoImp.invisible(user1);
                System.out.println(flag ? "删除成功" : "删除失败");
                break;
            case 3:
                User updateUser = InformationAndAccountView.changeMenuView();
                flag = managerDaoImp.update(updateUser);
                System.out.println(flag ? "修改成功" : "修改失败");
                break;
            case 4:
                User user2 = InformationAndAccountView.selectMenuView();
                User select = managerDaoImp.select(user2);
                System.out.println("查询结果为： " + select);
                break;
            default:
                break;
        }
    }
}
