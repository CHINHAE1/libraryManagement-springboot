package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Order)实体类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderID;

    private Double totalPrice;

    private Date orderdate;

    private String remarks;

    private Integer userID;

}

