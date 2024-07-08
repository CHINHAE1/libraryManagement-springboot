package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * (Item)实体类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Integer itemID;

    private Integer bookID;

    private String itemName;

    private Integer quantity;

    private Double itemPrice;

    private Double totalPrice;

}

