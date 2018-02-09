package edu.mwsu.springframework.bookshare.service;

import edu.mwsu.springframework.bookshare.domain.Book;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class BookAdServiceImpl implements BookAdService {

    //use hash map to act as a db
    private Map<Integer, Book> books;



    //bootstrap some data initial data
    private void loadProducts(){

        this.books = new HashMap<>();

        Book book1 = new Book();
        book1.setId(1);
        book1.setDescription("Book 1");
        book1.setPrice(new BigDecimal(12.99));
        book1.setImageUrl("http://example.com/book1");

        books.put(1, book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setDescription("Book 2");
        book2.setPrice(new BigDecimal(12.99));
        book2.setImageUrl("http://example.com/book2");

        books.put(2, book2);

        Book book3 = new Book();
        book3.setId(3);
        book3.setDescription("Book 3");
        book3.setPrice(new BigDecimal(12.99));
        book3.setImageUrl("http://example.com/book3");

        books.put(3, book3);

        Book book4 = new Book();
        book4.setId(4);
        book4.setDescription("Book 4");
        book4.setPrice(new BigDecimal(12.99));
        book4.setImageUrl("http://example.com/book4");

        books.put(4, book4);

        Book book5 = new Book();
        book5.setId(5);
        book5.setDescription("Book 5");
        book5.setPrice(new BigDecimal(12.99));
        book5.setImageUrl("http://example.com/book5");

        books.put(5, book5);
    }

    public BookAdServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Book> listProducts() {

        return new ArrayList<>(books.values());
    }

    @Override
    public void delete(Integer id){ books.remove(id); }

    @Override
    public Book getProductById(Integer id) {
        return books.get(id);
    }

    @Override
    public Book saveOrUpdate(Book book) {

        if(book != null){
            if(book.getId() != null){//this is update

            }else{//this is brand new
                book.setId(getNextKey());
            }
            books.put(book.getId(), book);//save it in hash map
        }else{
            throw new RuntimeException("Cannot create book!");
        }

        return book;
    }

    private Integer getNextKey(){
        if (books.size() == 0)
            return 1;
        return Collections.max(books.keySet()) + 1;
    }
}
