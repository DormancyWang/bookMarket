package com.guo.service.impl;

import com.guo.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {

    BookService  bookService = new BookServiceImpl();
    @Test
    void addBook() {
    }

    @Test
    void deleteBookById() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void queryBookById() {
    }

    @Test
    void queryBooks() {
    }

    @Test
    void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,4,0,5));
    }

    @Test
    void page() {
    }
}