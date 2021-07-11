package com.hsq.dao;

import com.hsq.bean.User;

public interface UserDao {
    // 我在这里可以写很多接口，目前只有对账户的增删改查，但是我需要一个对学生的
    // 然后有些可以重写两次，比如select，可以写个join的；insert，需要一个注册的insert和一个添加成绩的insert；

    /**
     * 添加】
     *
     * @param user
     * @return 成功 true;失败 false
     */
    boolean insert(User user);


    /**
     * 不可见(删除)
     *
     * @param user 要删除的对象，包含账户和密码,还有很多信息
     * @return 成功 true;失败 false
     */
    boolean invisible(User user);


    /**
     * 修改学生信息
     *
     * @param user 要修改的对象，包含账户和密码
     * @return 成功 true;失败 false
     */
    boolean update(User user);


    /**
     * 查询学生信息
     *
     * @param user 要修改的对象，包含账户和密码
     * @return 成功 User;失败 null
     */

    User select(User user);


}
