package com.guo.dao.impl;

import com.guo.dao.BookDao;
import com.guo.pojo.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    void test2(){
        System.out.println(bookDao.queryForPageTotalCount(0, 5));
    }

    @Test
    void getItems() {
        List<Book> items = bookDao.getItems(1, 4, 0, 99);
        for(Book book : items){
            System.out.println(book);
        }
    }
}