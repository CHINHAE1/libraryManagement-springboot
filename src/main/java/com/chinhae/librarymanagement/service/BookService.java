package com.chinhae.librarymanagement.service;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.result.Result;

import java.util.List;

/**
 * (Book)表服务接口
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:36
 */
public interface BookService {

    /**
     * 获取所有书籍
     *
     * @return 书籍列表
     */
    List<Book> getAllBooks();

    // 根据书籍编号购买书籍
    Result purchaseBookById(int userID, int bookID, int quantity);

    // 根据书籍名称购买书籍
    Result purchaseBookByName(int userID, String bookName, int quantity);




}
