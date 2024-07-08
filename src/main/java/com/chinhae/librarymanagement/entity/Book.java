package com.chinhae.librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * (Book)实体类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer bookID;

    private String bookName;

    private String image;

    private String author;     // 作者

    private String type;       // 类型

    private Double price;

    private Integer stock;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}

