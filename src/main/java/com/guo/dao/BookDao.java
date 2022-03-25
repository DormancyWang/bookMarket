package com.guo.dao;

import com.guo.pojo.Book;

import java.util.List;

public interface BookDao {
    public  int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBook(Integer id);
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

     List<Book> getItems(int begin,int pageSize);

    Integer queryForPageTotalCount(int begin, int end);

    List<Book> getItems(int begin, Integer pageSize, int low, int high);

    Book queryBookById(Integer id);
}
