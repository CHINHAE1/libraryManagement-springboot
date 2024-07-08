package com.chinhae.librarymanagement.controller;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.Item;
import com.chinhae.librarymanagement.entity.ShoppingCart;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<Integer, ShoppingCart> userCarts = new HashMap<>();

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

    @PostMapping("/purchase/add")
    public Result addToCart(@RequestParam int userID, @RequestParam int bookID, @RequestParam int quantity) {
        Book book = bookService.getBookById(bookID);
        if (book == null) {
            return new Result(404, "书籍不存在", null);
        }
        ShoppingCart cart = userCarts.computeIfAbsent(userID, k -> new ShoppingCart(userID, new ArrayList<>()));
        Item item = new Item(null, bookID, book.getBookName(), quantity, book.getPrice(), book.getPrice() * quantity);
        cart.addItem(item);
        return new Result(0, "成功添加到购物车", cart);
    }

    @PostMapping("/purchase/checkout")
    public Result checkout(@RequestParam int userID) {
        ShoppingCart cart = userCarts.get(userID);
        if (cart == null || cart.getItems().isEmpty()) {
            return new Result(400, "购物车为空", null);
        }
        double totalPrice = cart.calculateTotalPrice();
        if (!bookService.checkUserBalance(userID, totalPrice)) {
            return new Result(400, "余额不足", null);
        }
        Result result = bookService.checkout(userID, cart);
        if (result.getCode() == 0) {
            userCarts.remove(userID);
        }
        return result;
    }


    @GetMapping("/cart")
    public Result getCart(@RequestParam int userID) {
        ShoppingCart cart = userCarts.get(userID);
        if (cart == null || cart.getItems().isEmpty()) {
            return new Result(400, "购物车为空", null);
        }
        return new Result(0, "成功获取购物车", cart);
    }


    // 根据书籍编号购买书籍
  /*  @PostMapping("/purchase/byID")
    public Result purchaseBookById(@RequestParam int userID, @RequestParam int bookID, @RequestParam int quantity) {
        return bookService.purchaseBookById(userID, bookID, quantity);
    }*/

    // 根据书籍名称购买书籍
    /*@PostMapping("/purchase/byName")
    public Result purchaseBookByName(@RequestParam int userID, @RequestParam String bookName, @RequestParam int quantity) {
        return bookService.purchaseBookByName(userID, bookName, quantity);
    }*/
}

