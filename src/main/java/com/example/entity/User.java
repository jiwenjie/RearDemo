package com.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * author: Jiwenjie
 * email: Jiwenjie97@gmail.com
 * time: 2018-12-22
 * desc:
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // 去除返回接口值为 null 的字段
public class User {

    private Integer id;
    private String username;
    private String phone;
    private int isAdmin;
    private String avatar;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdmin=" + isAdmin +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
