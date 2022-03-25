package com.guo.dao.impl;

import com.guo.dao.BookDao;
import com.guo.pojo.Book;


import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql, book.getName(),
                book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(),
                book.getImgPath(), book.getId());

    }

    @Override
    public Book queryBook(Integer id) {
        String sql = "select `id` , `name` , `author`" +
                " , `price` , `sales` , `stock` , `img_path` imgPath " +
                "from t_book where id = ? ";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author`" +
                " , `price` , `sales` , `stock` , `img_path` imgPath " +
                "from t_book ";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Object obj = queryForSingleValue(sql);
        Integer number = Integer.parseInt(obj.toString());
        return number;
    }

    @Override
    public  List<Book> getItems(int begin,int pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book limit ?,?";

        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCount(int begin, int end) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Object obj = queryForSingleValue(sql,begin,end);
        Integer number = Integer.parseInt(obj.toString());
        return number;
    }

    @Override
    public List<Book> getItems(int begin, Integer pageSize, int low, int high) {
        String sql = "select id,name,author,price,sales,stock,img_path from t_book where price between ? and ? order by price limit ?,? ";

        return queryForList(Book.class,sql,low,high,begin,pageSize);
    }

    @Override
    public Book queryBookById(Integer id) {
        return null;
    }
}
