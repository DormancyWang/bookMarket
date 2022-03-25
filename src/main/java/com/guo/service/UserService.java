package com.guo.service;

import com.guo.pojo.User;

public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public boolean existsUsername(String name);
}
