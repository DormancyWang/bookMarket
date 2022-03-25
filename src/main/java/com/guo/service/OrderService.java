package com.guo.service;


import com.guo.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
