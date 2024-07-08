package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Book)表控制层
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:36
 */
@RestController
@RequestMapping("/books")
public class BookController {
    /**
     * 服务对象
     */
    @Autowired
    private BookService bookService;

    /**
     * 获取所有书籍信息
     *
     * @return 书籍列表
     */
    @GetMapping
    public Result getAllBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            return new Result(0, "成功获取所有书籍", books);
        } catch (Exception e) {
            return new Result(404, e.getMessage(), null);
        }
    }

    // 根据书籍编号购买书籍
    @PostMapping("/purchase/byID")
    public Result purchaseBookById(@RequestParam int userID, @RequestParam int bookID, @RequestParam int quantity) {
        return bookService.purchaseBookById(userID, bookID, quantity);
    }

    // 根据书籍名称购买书籍
    @PostMapping("/purchase/byName")
    public Result purchaseBookByName(@RequestParam int userID, @RequestParam String bookName, @RequestParam int quantity) {
        return bookService.purchaseBookByName(userID, bookName, quantity);
    }
}

