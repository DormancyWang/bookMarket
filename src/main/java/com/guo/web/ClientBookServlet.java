package com.guo.web;

import com.guo.pojo.Book;
import com.guo.pojo.Page;
import com.guo.service.BookService;
import com.guo.service.impl.BookServiceImpl;
import com.guo.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
    }


    public void pageByPrice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int begin = WebUtils.parseInt(req.getParameter("min"),0);
        int end = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,begin,end);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") !=null){
            sb.append("&min="+begin);
        }
        if(req.getParameter("max") !=null ){
            sb.append("&max="+end);
        }
        page.setUrl(sb.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
    }



}
