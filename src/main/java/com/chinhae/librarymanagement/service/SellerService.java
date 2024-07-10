package com.chinhae.librarymanagement.service;

import com.chinhae.librarymanagement.entity.Book;
import com.chinhae.librarymanagement.entity.User;
import com.chinhae.librarymanagement.result.Result;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/10 17:47
 * @version: 1.0
 */
public interface SellerService {

    /**
     * 新增书籍
     *
     * @param book 用户实体
     * @return 操作结果
     */
    Result addBooks(Book book);

    // 删除书籍
    Result deleteBooks(Book book);

    // 修改书籍
    Result updateBooks(Book book);

}
