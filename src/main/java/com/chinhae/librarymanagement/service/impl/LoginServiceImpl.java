package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.form.LoginForm;
import com.chinhae.librarymanagement.mapper.UserMapper;
import com.chinhae.librarymanagement.result.LoginResult;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.LoginService;
import com.chinhae.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/9 02:41
 * @version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public LoginResult login(LoginForm loginForm) {

        LoginResult loginResult = new LoginResult();

        // 根据角色ID进行不同的验证
        switch (loginForm.getRoleID()) {
            case 1:
                User user = this.userMapper.queryByUsername(loginForm.getUserName());
                if (user == null) {
                    loginResult.setMsg("用户名不存在");
                    return loginResult;
                }
                // 验证密码
                if (!user.getPassword().equals(loginForm.getPassword())) {
                    loginResult.setMsg("密码错误");
                    return loginResult;
                }
                loginResult.setMsg("登录成功");
                loginResult.setObject(user);

                break;
            case 2:
            case 3:
        }
        return loginResult;
    }


    @Override
    public Result validateUserCredentials(String userName, String password) {
        // 检查输入参数是否为空
        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            return Result.error("用户名或密码不能为空");
        }

        User user = userMapper.queryByUsername(userName);
        if (user == null) {
            return Result.error("用户不存在");
        }
        // 直接比对数据库中的密码和输入的密码
        if (!user.getPassword().equals(password)) {
            return Result.error("用户名或密码错误");
        }
        return Result.success(user);
    }

}
