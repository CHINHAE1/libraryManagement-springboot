package com.chinhae.librarymanagement.mapper;

import com.chinhae.librarymanagement.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * (User)表数据库访问层
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名统计用户数量
     *
     * @param userName 用户名
     * @return 用户数量
     */
    int countByUsername(@Param("userName") String userName);


    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户实体
     */
    @Select("SELECT * FROM user WHERE userName = #{userName}")
    User queryByUsername(@Param("userName") String userName);

    /**
     * 更新用户余额
     *
     * @param user 用户实体
     */
    @Update("UPDATE user SET Balance = #{balance}, update_time = #{updateTime} WHERE UserName = #{userName}")
    void updateBalance(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    void insert(User user);

    // 更新用户余额
    @Update("UPDATE User SET balance = balance + #{amount} WHERE userID = #{userID}")
    void updateBuyBalance(@Param("userID") int userID, @Param("amount") double amount);
}

