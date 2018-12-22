package com.example.service;

import com.example.entity.User;


/**
 * author: Jiwenjie
 * email: Jiwenjie97@gmail.com
 * time: 2018-12-22
 * desc:
 */
public interface UserService {

    void registerUser(String username, String password, String phone);

    User userLogin(String username, String password);

    User findUserByName(String username);

    User findUserByPhone(String phone);

}
