# 备忘录系统 (Memorandum System)

一个简易的备忘录系统，支持用户注册、登录以及备忘录的增删改查功能，用于练习spring boot+mybatis，适合初学者

## ✨ 功能特点

- 📝 **用户管理**：注册、登录功能
- 📅 **备忘录管理**：创建、查看、编辑、删除备忘录
- 🏷️ **分类管理**：支持备忘录分类
- 📱 **响应式设计**：适配不同设备
- 🗄️ **数据持久化**：使用 MySQL 数据库存储

## 🛠️ 技术栈

- **后端**：Java Spring Boot 3.2.5
- **前端**：HTML5, CSS3, JavaScript
- **数据库**：MySQL
- **ORM**：MyBatis 3.0.3
- **构建工具**：Maven

## 📁 项目结构

memorandum/ ├── src/ │ ├── main/ │ │ ├── java/com/example/memorandum/ │ │ │ ├── controller/ # 控制器 │ │ │ ├── entity/ # 实体类 │ │ │ ├── mapper/ # MyBatis 映射 │ │ │ ├── service/ # 服务层 │ │ │ └── MemorandumApplication.java # 主启动类 │ │ └── resources/ │ │ ├── static/ # 静态资源 │ │ └── application.yml # 配置文件 │ └── test/ ├── pom.xml # Maven 配置 └── README.md # 项目说明


plainText

## 🔧 快速开始

### 环境要求

- JDK 17+
- MySQL 5.7+
- Maven 3.6+

### 数据库配置

1. 创建数据库：
   ```sql
   CREATE DATABASE memorandum CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

2. 创建表结构：
   ```sql
   -- 用户表
   CREATE TABLE `user` (
     `id` INT PRIMARY KEY AUTO_INCREMENT,
     `username` VARCHAR(50) NOT NULL UNIQUE,
     `password` VARCHAR(50) NOT NULL,
     `create_time` DATETIME NOT NULL
   );

   -- 备忘录表
   CREATE TABLE `note` (
     `id` INT PRIMARY KEY AUTO_INCREMENT,
     `title` VARCHAR(100) NOT NULL,
     `content` TEXT NOT NULL,
     `category` VARCHAR(50),
     `create_time` DATETIME NOT NULL,
     `user_id` INT NOT NULL,
     FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
   );
   ```

### 配置修改

修改 `src/main/resources/application.yml` 文件：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/memorandum?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root  # 你的 MySQL 用户名
    password: 123456  # 你的 MySQL 密码
```

### 运行项目

1. 编译项目：
   ```bash
   mvn clean package
   ```

2. 运行项目：
   ```bash
   java -jar target/memorandum-1.0.0.jar
   ```

3. 访问系统：
   - 登录页面：http://localhost:8081/login.html
   - 备忘录列表：http://localhost:8081/index.html
 ## 🔐 许可证

本项目采用 MIT 许可证 - 详情见 [LICENSE](LICENSE) 文件

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来帮助改进这个项目！

## 📞 联系方式

- 作者：Hp666720
- GitHub：[https://github.com/Hp666720/memorandum1](https://github.com/Hp666720/memorandum1)
