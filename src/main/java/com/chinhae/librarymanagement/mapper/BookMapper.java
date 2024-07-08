package com.chinhae.librarymanagement.mapper;

import com.chinhae.librarymanagement.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Book)表数据库访问层
 *
 * @author CHINHAE
 * @since 2024-07-08 11:51:36
 */
@Mapper
public interface BookMapper {

    /**
     * 查询所有书籍
     *
     * @return 书籍列表
     */
    @Select("SELECT * FROM book")
    List<Book> queryAllBooks();

    // 根据书籍编号查询书籍
    @Select("SELECT * FROM Book WHERE bookID = #{bookID}")
    Book queryById(@Param("bookID") int bookID);

    // 根据书籍名称查询书籍
    @Select("SELECT * FROM Book WHERE bookName = #{bookName}")
    Book queryByName(@Param("bookName") String bookName);

    // 更新库存
    @Update("UPDATE Book SET stock = #{stock} WHERE bookID = #{bookID}")
    void updateStock(Book book);
}

