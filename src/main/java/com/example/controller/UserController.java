package com.example.controller;

import com.example.common.Constant;
import com.example.entity.User;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * author: Jiwenjie
 * email: Jiwenjie97@gmail.com
 * time: 2018-12-22
 * desc:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;
    /**
     * 注册用户接口
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @return 注册结果
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String phone) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("进入注册响应");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        System.out.println("手机号：" + phone);

        /**
         * 是否存在相同用户名用户
         */
        User nUser = userService.findUserByName(username);
        User pUser = userService.findUserByPhone(phone);
        if (nUser != null) {
            map.put("message", "the username has been register");
            map.put("code", HttpStatus.BAD_REQUEST.value());
        } else if (pUser != null) {
            map.put("message", "the phone number has been register");
            map.put("code", HttpStatus.BAD_REQUEST.value());
        } else {
            try {
                userService.registerUser(username, password, phone);
                map.put("message", "succeed");
                map.put("code", HttpStatus.OK.value());
            } catch (Exception e) {
                map.put("message", "failed");
                map.put("code", HttpStatus.BAD_REQUEST.value());
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 用户登录接口
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录结果
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userLogin(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("进入登陆接口");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        User user = userService.userLogin(username, password);
        if (user != null) {
            session.setAttribute(Constant.SESSION_USER, user);
            map.put("user", user);
            map.put("code", HttpStatus.OK.value());
            map.put("message", "succeed");
            System.out.println("登陆成功");
        } else {
            map.put("message", "not register");
            map.put("code", HttpStatus.NOT_FOUND.value());
            System.out.println("登陆失败");
        }
        return map;
    }
}