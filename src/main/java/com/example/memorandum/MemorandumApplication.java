package com.example.memorandum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 备忘录系统主启动类
 * 作为Spring Boot应用的入口点
 */
@SpringBootApplication
@MapperScan("com.example.memorandum.mapper")
public class MemorandumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemorandumApplication.class, args);
    }

}
