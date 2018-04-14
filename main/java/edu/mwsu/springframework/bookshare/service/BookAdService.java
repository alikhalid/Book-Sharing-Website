package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;

import java.util.List;

public interface BookAdService {
    List<BookAd> listBooks(String filter, String searchBy);
    List<BookAd> applyFilter(String filter, String cat);
    BookAd getBookById(Integer id);
    BookAd saveOrUpdate(BookAd bookAd);
    void delete(String hashKey);
    BookAd getBookByHashKey(String hashKey);
    boolean verifyHash(Integer id, String hashKey);

}
