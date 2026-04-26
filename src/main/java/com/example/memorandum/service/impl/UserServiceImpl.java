package com.example.memorandum.service.impl;

import com.example.memorandum.entity.User;
import com.example.memorandum.mapper.UserMapper;
import com.example.memorandum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * 用户服务接口
 * 定义用户相关的业务方法
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *  实现步骤：
     *    1. 检查用户名是否已存在
     *    2. 如果不存在，则插入新用户数据
     * @param user 用户信息
     * @return 注册是否成功
     */
    @Override
    public boolean register(User user) {
        // 1. 检查用户名是否已存在
        User existUser = userMapper.findByUsername(user.getUsername());
        if(existUser != null){
            return false; // 用户名已存在
        }
        // 2. 设置创建时间
        user.setCreateTime(new Date());

        // 3. 插入新用户数据
        int rows = userMapper.insert(user);

        // 4. 返回插入结果（rows > 0 表示成功）
        return rows > 0;

    }

    /**
     * 用户登录
     *  * 实现步骤：
     *  1. 根据用户名查询用户
     *  2. 检查密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回用户信息，失败返回null
     */
    @Override
    public User login(String username, String password) {
        // 1. 根据用户名查询用户
        User user = userMapper.findByUsername(username);
        if(user == null){
            // 用户不存在，登录失败
            return null;
        }
        // 2. 检查密码是否匹配
        if(user.getPassword().equals(password)){
            // 密码匹配，登录成功
            return user;
        }
        // 密码错误，登录失败
        return null;
    }



}
