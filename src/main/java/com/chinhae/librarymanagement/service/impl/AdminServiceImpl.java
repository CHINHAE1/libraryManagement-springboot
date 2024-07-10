package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.mapper.UserMapper;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 19:02
 * @version: 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 注册新用户
     *
     * @param user 用户实体
     * @return 操作结果
     */
    @Override
    public Result registerUser(User user) {
        // 检查用户名是否已经存在
        if (userMapper.countByUsername(user.getUserName()) > 0) {
            return Result.error("用户已存在");
        }

        // 设置默认值
        user.setBalance(BigDecimal.ZERO); // 默认金额为0.0
        user.setRoleID(2); // 默认角色ID为2，假设2是买家角色
        user.setCreateTime(LocalDateTime.now()); // 设置创建时间
        user.setUpdateTime(LocalDateTime.now()); // 设置更新时间

        // 保存新用户
        userMapper.insert(user);
        return Result.success();
    }

    //  根据用户编号实现删除用户
    @Override
    public Result deleteUser(Integer userId) {
        // 检查用户是否存在
        if (userMapper.queryById(userId) == null) {
            return Result.error("用户不存在");
        }

            // 删除用户
            userMapper.deleteById(userId);
            return Result.success();
    }

    // 修改用户信息
    @Override
    public Result updateUser(User user) {
        // 检查用户是否存在
        if (userMapper.queryById(user.getUserID()) == null) {
            return Result.error("用户不存在");
        }

        // 更新用户信息
        userMapper.updateById(user);
        return Result.success();
    }

    //  获取所有用户信息
    @Override
    public List<User> getAllUsers() {
        return userMapper.queryAllUsers();
    }
}
