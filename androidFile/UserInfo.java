package com.kuky.base.kotlin.demo.test.bean;

import java.io.Serializable;
import java.util.List;

/**
 * author:Jiwenjie
 * email:278630464@qq.com
 * time:2018/12/14
 * desc:
 * version:1.0
 */
public class UserInfo implements Serializable {

    /**
     * {
     * "code":200,
     * "message":"succeed",
     * "user":{
     * "id":2,
     * "username":"admin",
     * "phone":"13965972584",
     * "isAdmin":0}
     * }
     **/
    private Integer code;
    private String message;
    private User user;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User implements Serializable {

        private Integer id;
        private String username;
        private String phone;
        private int isAdmin;
        private String avatar;
        private String password;

        @Override
        public String toString() {
            return "User {" +
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
}
