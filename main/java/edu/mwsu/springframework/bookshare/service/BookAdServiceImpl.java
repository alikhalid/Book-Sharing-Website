package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.BookAd;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class BookAdServiceImpl implements BookAdService {

    //use hash map to act as a db
    private Map<Integer, BookAd> bookAds;

    //bootstrap some data initial data
    private void loadBooks(){

        this.bookAds = new HashMap<>();

        BookAd bookAd1 = new BookAd();
        bookAd1.setId(1);
        bookAd1.setDescription("BookAd 1");
        bookAd1.setPrice(new BigDecimal(12.99));
        bookAd1.setImageUrl("http://example.com/bookAd1");

        bookAds.put(1, bookAd1);

        BookAd bookAd2 = new BookAd();
        bookAd2.setId(2);
        bookAd2.setDescription("BookAd 2");
        bookAd2.setPrice(new BigDecimal(12.99));
        bookAd2.setImageUrl("http://example.com/bookAd2");

        bookAds.put(2, bookAd2);

        BookAd bookAd3 = new BookAd();
        bookAd3.setId(3);
        bookAd3.setDescription("BookAd 3");
        bookAd3.setPrice(new BigDecimal(12.99));
        bookAd3.setImageUrl("http://example.com/bookAd3");

        bookAds.put(3, bookAd3);

        BookAd bookAd4 = new BookAd();
        bookAd4.setId(4);
        bookAd4.setDescription("BookAd 4");
        bookAd4.setPrice(new BigDecimal(12.99));
        bookAd4.setImageUrl("http://example.com/bookAd4");

        bookAds.put(4, bookAd4);

        BookAd bookAd5 = new BookAd();
        bookAd5.setId(5);
        bookAd5.setDescription("BookAd 5");
        bookAd5.setPrice(new BigDecimal(12.99));
        bookAd5.setImageUrl("http://example.com/bookAd5");

        bookAds.put(5, bookAd5);
    }

    public BookAdServiceImpl() {
        loadBooks();
    }

    @Override
    public List<BookAd> listBooks(String filter) {

        if(filter.equals("all")) {
            return new ArrayList<>(bookAds.values());
        }
        else {
            ArrayList<BookAd> filteredAds = new ArrayList<>();
            for (Map.Entry<Integer, BookAd> ad : bookAds.entrySet()) {
                if(ad.getValue().getCourseName() == filter)
                    filteredAds.add(ad.getValue());
            }
            return filteredAds;
        }
    }

    @Override
    public void delete(Integer id){ bookAds.remove(id); }

    @Override
    public BookAd getBookById(Integer id) {
        return bookAds.get(id);
    }

    @Override
    public BookAd saveOrUpdate(BookAd bookAd) {

        if(bookAd != null){
            if(bookAd.getId() != null){//this is update

            }else{//this is new
                bookAd.setId(getNextKey());
            }
            bookAds.put(bookAd.getId(), bookAd);//save it in hash map
        }else{
            throw new RuntimeException("Cannot create bookAd!");
        }

        return bookAd;
    }

    private Integer getNextKey(){
        if (bookAds.size() == 0)
            return 1;
        return Collections.max(bookAds.keySet()) + 1;
    }
}
