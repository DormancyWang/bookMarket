package com.guo.service.impl;

import com.guo.dao.BookDao;
import com.guo.dao.impl.BookDaoImpl;
import com.guo.pojo.Book;
import com.guo.pojo.Page;
import com.guo.service.BookService;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBook(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int low, int high) {
        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount(low,high);

        page.setPageTotalCount(pageTotalCount);

        int temp;
        if (pageTotalCount % pageSize != 0) {
            temp = (pageTotalCount / pageSize) + 1;
        } else {
            temp = pageTotalCount / pageSize;
        }
        if(pageTotalCount == 0) temp = 1;
        page.setPageTotal(temp);

        //处理跳转页数非法的问题
        if(pageNo > temp) pageNo = temp;
        if(pageNo < 1) pageNo = 1;

        int begin = (pageNo - 1) * pageSize;
        List<Book> item = bookDao.getItems(begin, page.getPageSize(),low,high);
        page.setItems(item);
        page.setPageNo(pageNo);
        return page;
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        page.setPageNo(pageNo);
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        int temp;
        if (pageTotalCount % pageSize != 0) {
            temp = (pageTotalCount / pageSize) + 1;
        } else {
            temp = pageTotalCount / pageSize;
        }

        page.setPageTotal(temp);

        //处理跳转页数非法的问题
        if(pageNo > temp) pageNo = temp;
        if(pageNo < 1) pageNo = 1;

        int begin = (pageNo - 1) * pageSize;
        List<Book> item = bookDao.getItems(begin, page.getPageSize());
        page.setItems(item);
        page.setPageNo(pageNo);
        return page;
    }

}
