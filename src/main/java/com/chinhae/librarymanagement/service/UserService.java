package com.chinhae.librarymanagement.service;

import com.chinhae.librarymanagement.entity.Result;
import com.chinhae.librarymanagement.entity.User;

import java.math.BigDecimal;

/**
 * (User)表服务接口
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
public interface UserService {


    /**
     * 通过用户名充值用户余额
     *
     * @param userName 用户名
     * @param amount 充值金额
     * @return 操作结果
     */
    Result rechargeUserByUsername(String userName, BigDecimal amount);


    Result validateUserCredentials(String userName, String password);


    /**
     * 注册新用户
     *
     * @param user 用户实体
     * @return 操作结果
     */
    Result registerUser(User user);


    /**
     * 保存用户
     *
     * @param user 用户实体
     */
    void saveUser(User user);


}
