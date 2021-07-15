package com.hsq.dao.login;

import com.hsq.bean.User;

public interface LonginDao {
    /**
     * 登陆的方法
     *
     * @param user uname ;upass
     * @return
     */
    int login(User user);
}
