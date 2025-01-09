package com.example.movieplanet.controller;

import com.example.movieplanet.entity.Users;
import com.example.movieplanet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login") // 处理登录请求的接口的 POST 请求版本
    public boolean loginUser(@RequestBody Map<String, String> loginData) {
        String userEmail = loginData.get("userEmail");
        String password = loginData.get("password");

        // 使用 validateUser 方法验证用户
        return userService.validateUser(userEmail, password);
    }

    @PostMapping("/register") // 处理注册请求的接口
    public Users registerUser(@RequestBody Users user) {
        System.out.println("Received registration request for user: " + user);
        // 在这里将用户数据存储到数据库中
        return userService.registerUser(user);
    }

    // 获取用户是否是vip
    @GetMapping("/isVip")
    public boolean isUserVip(@RequestParam String email) {
        return userService.isUserVip(email);
    }

    @GetMapping("/isAdmin")
    public boolean isUserAdmin(@RequestParam("email") String email) {
        return userService.isUserAdmin(email);
    }
}