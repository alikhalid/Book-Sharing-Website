package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;

public interface EmailService {
    public void sendHash(BookAd bookAd, String email);
}
