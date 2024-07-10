package com.chinhae.librarymanagement.mapper;

import com.chinhae.librarymanagement.entity.Item;
import com.chinhae.librarymanagement.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Mapper
public interface UserMapper {

    //  获取所有用户信息
    @Select("SELECT * FROM user")
    List<User> queryAllUsers();

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
     * 通过用户id查询用户
     *
     * @param userID 用户名
     * @return 用户实体
     */
    @Select("SELECT * FROM user WHERE userID = #{userID}")
    User queryById(@Param("userID") int userID);


    // 通过用户id删除用户
    @Delete("DELETE FROM user WHERE userID = #{userID}")
    void deleteById(@Param("userID") int userID);

    // 根据用户id修改用户信息
    @Update("UPDATE user SET userName = #{userName}, password = #{password}, email = #{email}, phone = #{phone}, address = #{address}, update_time = #{updateTime} WHERE userID = #{userID}")
    void updateById(User user);

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

    @Select("SELECT balance FROM user WHERE userID = #{userID}")
    double getBalance(@Param("userID") int userID);


    @Insert("INSERT INTO order_items (userID, bookID, itemName, quantity, itemPrice, totalPrice) VALUES (#{userID}, #{bookID}, #{itemName}, #{quantity}, #{itemPrice}, #{totalPrice})")
    void insertOrderItem(@Param("userID") int userID, @Param("item") Item item);

    @Insert("INSERT INTO orders (userID, totalPrice) VALUES (#{userID}, #{totalPrice})")
    void insertOrder(@Param("userID") int userID, @Param("totalPrice") double totalPrice);
}

