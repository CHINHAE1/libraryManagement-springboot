package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Orderitemrelation)实体类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderitemrelation {

    private Integer relationID;

    private Integer orderID;

    private Integer itemID;

}

