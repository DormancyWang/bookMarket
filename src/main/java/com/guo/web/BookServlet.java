package com.guo.web;

import com.guo.pojo.Book;
import com.guo.pojo.Page;
import com.guo.service.BookService;
import com.guo.service.impl.BookServiceImpl;
import com.guo.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();


    /**
     * 处理分页的方法
     *
     * @param req
     * @param res
     * @throws Exception
     */
    public void page(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,res);
    }

    public void update(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        System.out.println(book);
        bookService.updateBook(book);
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }
    
    public void getBook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        Book book = bookService.queryBookById(i);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, res);
    }

    public void add(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }

    public void list(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, res);
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        bookService.deleteBookById(i);
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page");
    }


}
