package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * (User)实体类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userID;

    private String userName;

    private String password;

    private String image;

    private BigDecimal balance;

    private Integer roleID;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}

