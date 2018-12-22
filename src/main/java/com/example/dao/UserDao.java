package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * author: Jiwenjie
 * email: Jiwenjie97@gmail.com
 * time: 2018-12-22
 * desc:
 */
@Repository
public interface UserDao {

    void registerUser(@Param("username") String username, @Param("password") String password, @Param("phone") String phone);

    User userLogin(@Param("username") String username, @Param("password") String password);

    User findUserByName(@Param("username") String username);

    User findUserByPhone(@Param("phone") String phone);
}
