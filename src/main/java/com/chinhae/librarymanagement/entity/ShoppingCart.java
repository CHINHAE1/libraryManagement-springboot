package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是：购物车
 *
 * @author: CHINHAE
 * @date: 2024/7/9 04:06
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private int userID;
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }
}
