package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.mapper.UserMapper;
import com.chinhae.librarymanagement.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * (User)表服务实现类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:38
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 充值用户余额
     *
     * @param userName 用户名
     * @param amount 充值金额
     * @return 操作结果
     */
    @Override
    public Result rechargeUserByUsername(String userName, BigDecimal amount) {
        // 通过用户名查询用户
        User user = userMapper.queryByUsername(userName);
        if (user == null) {
            return Result.error("用户不存在");
        }

        // 更新用户余额
        user.setBalance(user.getBalance().add(amount));
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateBalance(user);

        return Result.success(user);
    }



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


    /**
     * 保存用户
     *
     * @param user 用户实体
     */
    @Override
    public void saveUser(User user) {
        // 补全数据
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        // 调用添加方法
        userMapper.insert(user);
    }




}
