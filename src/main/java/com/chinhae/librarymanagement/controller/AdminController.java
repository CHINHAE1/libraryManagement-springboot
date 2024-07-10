package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 18:59
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping("/registerUser")
    public Result registerUser(@RequestBody User user) {
        // 记录日志
        log.info("新增用户, user:{}", user);
        // 响应 返回结果
        return adminService.registerUser(user);
    }

    //  根据用户编号实现删除用户
    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestParam Integer userId) {
        // 记录日志
        log.info("删除用户, userId:{}", userId);
        // 响应 返回结果
        return adminService.deleteUser(userId);
    }

    // 修改用户信息
    @PostMapping("/updateUser")
    public Result updateBooks(@RequestBody User user) {
        // 记录日志
        log.info("修改书籍, user:{}", user);
        // 响应 返回结果
        return adminService.updateUser(user);
    }

    /**
     * 获取所有用户信息
     *
     * @return 用户列表
     */
    @GetMapping("/getAllUsers")
    public Result getAllUsers() {
        try {
            List<User> users = adminService.getAllUsers();
            return new Result(0, "成功获取所有用户信息", users);
        } catch (Exception e) {
            return new Result(404, e.getMessage(), null);
        }
    }
}
