package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.form.LoginForm;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.LoginService;
import com.chinhae.librarymanagement.utils.ResultTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/9 02:43
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController extends BaseController{

    /**
     * 服务对象
     */
    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *  @param userName
     *  @param password
     */
    /*@PostMapping
    public Result login(@RequestParam String userName, @RequestParam String password) {
        log.info("登录, userName:{}, password:{}", userName, password);
        try {
            Result result = userService.validateUserCredentials(userName, password);
            if (result.getCode() == 1) {
                User user = (User) result.getData();
                setUser(user);
                Map<String,Object> map = new HashMap<>();
                map.put("user", user);
                return ResultTools.result(0, "登录成功", map);
            } else {
                return result;
            }
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }*/

    @PostMapping
    public Result login(@RequestBody LoginForm loginForm) {
        log.info("登录, userName:{}, password:{}", loginForm.getUserName(), loginForm.getPassword());
        try {
            Result result = loginService.validateUserCredentials(loginForm.getUserName(), loginForm.getPassword());
            if (result.getCode() == 1) {
                User user = (User) result.getData();
                setUser(user);
                Map<String,Object> map = new HashMap<>();
                map.put("user", user);
                return ResultTools.result(0, "登录成功", map);
            } else {
                return result;
            }
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }


    /***
     * 获取用户
     */
    @GetMapping("/getUser")
    public Result getLoginUser() {
        try {
            Map<String, Object> map = new HashMap<>(1);
            User user = getUser();
            if (user == null) {
                return ResultTools.result(1002, "登录信息失效", map);
            }
            map.put("user", user);
            return ResultTools.result(0, "成功", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
    }
}
