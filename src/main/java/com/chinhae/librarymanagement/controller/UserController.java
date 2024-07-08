package com.chinhae.librarymanagement.controller;


import com.chinhae.librarymanagement.entity.Result;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.service.UserService;
import com.chinhae.librarymanagement.utils.ResultTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 * 处理用户相关的HTTP请求
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 登录
     *  @param userName
     *  @param password
     */
    @PostMapping("/login")
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


    /**
     * 通过用户名充值用户余额
     *
     * @param userName 用户名
     * @param amount 充值金额
     * @return 操作结果
     */
    @PostMapping("/recharge")
    public Result rechargeUserByUsername(@RequestParam String userName, @RequestParam BigDecimal amount) {
        log.info("给用户名为 {} 的用户充值金额: {}", userName, amount);
        return userService.rechargeUserByUsername(userName, amount);
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public Result registerUser(@RequestBody User user) {
        // 记录日志
        log.info("新增用户, user:{}", user);
        // 响应 返回结果
        return userService.registerUser(user);
    }


}

