package com.guo.service.impl;

import com.guo.dao.UserDao;
import com.guo.dao.impl.UserDaoImpl;
import com.guo.pojo.User;
import com.guo.service.UserService;


public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
        if(userDao.queryByUserName(name) == null){
            return false;
        }else{
            return true;
        }
    }
}
