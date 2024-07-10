package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.BookService;
import com.chinhae.librarymanagement.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 17:45
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BookService bookService;

    /**
     * 新增书籍
     *
     * @param book 实体
     * @return 新增结果
     */
    @PostMapping("/addBooks")
    public Result addBooks(@RequestBody Book book) {
        // 记录日志
        log.info("新增书籍, book:{}", book);
        // 响应 返回结果
        return sellerService.addBooks(book);
    }

    /**
    * 删除书籍
    */
    @PostMapping("/deleteBooks")
    public Result deleteBooks(@RequestBody Book book) {
        // 记录日志
        log.info("删除书籍, book:{}", book);
        // 响应 返回结果
        return sellerService.deleteBooks(book);
    }

    // 修改书籍
    @PostMapping("/updateBooks")
    public Result updateBooks(@RequestBody Book book) {
        // 记录日志
        log.info("修改书籍, book:{}", book);
        // 响应 返回结果
        return sellerService.updateBooks(book);
    }

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

}
