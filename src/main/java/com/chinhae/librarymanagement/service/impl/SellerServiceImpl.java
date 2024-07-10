package com.chinhae.librarymanagement.service.impl;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.mapper.BookMapper;
import com.chinhae.librarymanagement.result.Result;
import com.chinhae.librarymanagement.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 17:47
 * @version: 1.0
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Result addBooks(Book book) {
        // 检查书籍是否已经存在
        if (bookMapper.queryByName(book.getBookName()) != null) {
            return Result.error("书籍已存在");
        }

        // 设置默认值
        book.setCreateTime(LocalDateTime.now()); // 设置创建时间
        book.setUpdateTime(LocalDateTime.now()); // 设置更新时间

        // 保存新用户
        bookMapper.insert(book);
        return Result.success();
    }

    //  根据书籍名删除书籍
    @Override
    public Result deleteBooks(Book book) {
        // 检查书籍是否存在
        if (bookMapper.queryByName(book.getBookName()) == null) {
            return Result.error("书籍不存在");
        }

        // 删除书籍
        bookMapper.deleteByName(book.getBookName());
        return Result.success();
    }

    //  根据书籍名修改书籍信息
    @Override
    public Result updateBooks(Book book) {
        // 检查书籍是否存在
        if (bookMapper.queryByName(book.getBookName()) == null) {
            return Result.error("书籍不存在");
        }

        // 更新书籍信息
        bookMapper.updateByName(book);
        return Result.success();
    }
}
