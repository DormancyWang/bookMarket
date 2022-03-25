package com.guo.dao.impl;

import com.guo.dao.UserDao;
import com.guo.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByUserName(String name) {
        String sql = "select id,username,password,email from t_user where username = ? ";
        return queryForOne(User.class,sql,name);
    }

    @Override
    public User queryByUserNameAndPassword(String name, String password) {
        String sql = "select id,username,password,email from t_user where username = ?  and password  = ?";
        return queryForOne(User.class,sql,name,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) values(?,?,?) ";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
