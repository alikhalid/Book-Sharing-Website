package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;

import java.util.List;

public interface BookAdService {
    public List<BookAd> listBooks(String filter, String searchBy);
    public BookAd getBookById(Integer id);
    public BookAd saveOrUpdate(BookAd bookAd);
    public void delete(Integer id);
}
