package com.example.memorandum.mapper;

import com.example.memorandum.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据访问接口
 * 定义用户相关的数据操作方法
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 查询到的用户信息，未找到返回null
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    /**
     * 插入新用户
     * @param user 用户信息
     * @return 影响的行数
     */
    @Insert("INSERT INTO user (username, password, create_time) VALUES (#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

}
