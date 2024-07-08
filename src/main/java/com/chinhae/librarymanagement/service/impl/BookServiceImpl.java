package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.Result;
import com.chinhae.librarymanagement.mapper.BookMapper;
import com.chinhae.librarymanagement.mapper.UserMapper;
import com.chinhae.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Book)表服务实现类
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:36
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 获取所有书籍
     *
     * @return 书籍列表
     */
    @Override
    public List<Book> getAllBooks() {
        return bookMapper.queryAllBooks();
    }

    // 根据书籍编号购买书籍
    @Override
    public Result purchaseBookById(int userID, int bookID, int quantity) {
        Book book = bookMapper.queryById(bookID);
        if (book == null) {
            return new Result(404, "书籍不存在", null);
        }
        if (book.getStock() < quantity) {
            return new Result(400, "库存不足", null);
        }
        // 更新库存
        book.setStock(book.getStock() - quantity);
        bookMapper.updateStock(book);

        // 更新用户余额
        double totalPrice = book.getPrice() * quantity;
        userMapper.updateBuyBalance(userID, -totalPrice);

        return new Result(0, "购买成功", null);
    }

    // 根据书籍名称购买书籍
    @Override
    public Result purchaseBookByName(int userID, String bookName, int quantity) {
        Book book = bookMapper.queryByName(bookName);
        if (book == null) {
            return new Result(404, "书籍不存在", null);
        }
        if (book.getStock() < quantity) {
            return new Result(400, "库存不足", null);
        }

        // 更新库存
        book.setStock(book.getStock() - quantity);
        bookMapper.updateStock(book);

        // 更新用户余额
        double totalPrice = book.getPrice() * quantity;
        userMapper.updateBuyBalance(userID, -totalPrice);

        return new Result(0, "购买成功", null);
    }


}
