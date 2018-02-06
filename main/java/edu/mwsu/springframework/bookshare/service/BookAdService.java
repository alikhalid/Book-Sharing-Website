package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.Book;

import java.util.List;

public interface BookAdService {
    public List<Book> listBooks();
    public Book getBookById(Integer id);
    public Book saveOrUpdate(Book book);
    public void delete(Integer id);
}
