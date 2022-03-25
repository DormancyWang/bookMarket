package com.guo.dao;

import com.guo.pojo.User;

public interface UserDao {
    public User queryByUserName(String name);
    public User queryByUserNameAndPassword(String name,String password);
    public int saveUser(User user);
}
