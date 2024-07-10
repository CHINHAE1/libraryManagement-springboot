package com.chinhae.librarymanagement.service;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.result.Result;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 19:02
 * @version: 1.0
 */
public interface AdminService {

    /**
     * 注册新用户
     *
     * @param user 用户实体
     * @return 操作结果
     */
    Result registerUser(User user);

    //  根据用户编号实现删除用户
    Result deleteUser(Integer userId);

    // 修改用户信息
    Result updateUser(User user);

    //  获取所有用户信息
    List<User> getAllUsers();
}
