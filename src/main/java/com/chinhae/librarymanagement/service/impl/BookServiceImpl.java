package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.Item;
import com.chinhae.librarymanagement.entity.ShoppingCart;
import com.chinhae.librarymanagement.result.Result;
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


    @Override
    public Book getBookById(int bookID) {
        return bookMapper.queryById(bookID);
    }

    @Override
    public boolean checkUserBalance(int userID, double totalPrice) {
        double balance = userMapper.getBalance(userID);
        return balance >= totalPrice;
    }

    @Override
    public Result checkout(int userID, ShoppingCart cart) {
        double totalPrice = cart.calculateTotalPrice();

        // 更新用户余额
        userMapper.updateBuyBalance(userID, -totalPrice);

        // 更新库存并保存订单项
        for (Item item : cart.getItems()) {
            bookMapper.updateStock(item.getBookID(), item.getQuantity());
            userMapper.insertOrderItem(userID, item);
        }

        // 保存订单
        userMapper.insertOrder(userID, totalPrice);

        return new Result(0, "结算成功", null);
    }


    // 根据书籍编号购买书籍
   /* @Override
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
    }*/

    // 根据书籍名称购买书籍
   /* @Override
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
    }*/


}
