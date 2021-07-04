package com.hsq.Dao;

import com.hsq.bean.User;

public interface UserDao {
    /**
     * 验证登陆的方法
     *
     * @param user uname ;upass
     * @return int -1，fail; 1 admin;2 teacher;3 stu;
     */
    int login(User user);

    /**
     * 添加学生信息的方法
     *
     * @param user
     * @return 成功 true;失败 false
     */
    boolean insert(User user);

    /**
     * 用来删除学生信息
     *
     * @param uname 要删除的对象，包含账户和密码
     * @return 成功 true;失败 false
     */
    boolean delete(String uname);

    /**
     * 用来修改学生信息
     *
     * @param user 要修改的对象，包含账户和密码
     * @return 成功 true;失败 false
     */
    boolean update(User user);


    /**
     * 用来查询学生信息
     *
     * @param uname 要修改的对象，包含账户和密码
     * @return 成功 User;失败 null
     */

    User select(String uname);
}
