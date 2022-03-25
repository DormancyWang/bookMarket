package com.guo.service;

import com.guo.pojo.Book;
import com.guo.pojo.Page;

import java.util.List;

public interface BookService {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    <T> Page<T> page(int pageNo,int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize,int low,int high);
}
