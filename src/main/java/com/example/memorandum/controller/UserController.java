package com.example.memorandum.controller;

import com.example.memorandum.entity.User;
import com.example.memorandum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 * 处理用户注册和登录的HTTP请求
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册接口
     * @param user 用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();

        //简单参数校验
        if(user.getUsername() == null || user.getUsername().trim().isEmpty()){
            result.put("success",false);
            result.put("message","用户名不能为空");
            return result;
        }

        if(user.getPassword() ==null || user.getPassword().trim().isEmpty()){
            result.put("success",false);
            result.put("message","密码不能为空");
            return result;
        }

        // 调用服务层注册
        boolean isSuccess = userService.register(user);
        if(isSuccess){
            result.put("success",true);
            result.put("message","注册成功");
            return result;
        }else{
            result.put("success",false);
            result.put("message","用户名已存在");
        }
        return result;
    }


    /**
     * 用户登录接口
     * @param user 用户信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String, Object> result = new HashMap<>();

        if(user.getUsername() == null || user.getUsername().trim().isEmpty()){
            result.put("success",false);
            result.put("message","用户名不能为空");
            return result;
        }
        if(user.getPassword() == null || user.getPassword().trim().isEmpty()){
            result.put("success",false);
            result.put("message","密码不能为空");
            return result;
        }

        // 调用服务层登录
        User loginUser = userService.login(user.getUsername(), user.getPassword());

        if(loginUser != null){
            result.put("success",true);
            result.put("message","登录成功");
            result.put("data", loginUser);
            return result;
        }else{
            result.put("success",false);
            result.put("message","用户名或密码错误");
        }
        return result;

    }

}
