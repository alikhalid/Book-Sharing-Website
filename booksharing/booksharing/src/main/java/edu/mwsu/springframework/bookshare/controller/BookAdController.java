package edu.mwsu.springframework.bookshare.controller;

import edu.mwsu.springframework.bookshare.domain.Book;
import edu.mwsu.springframework.bookshare.service.BookAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookAdController {

    private BookAdService bookAdService;

    @Autowired
    public void setBookAdService(BookAdService bookAdService) {
        this.bookAdService = bookAdService;
    }

    @RequestMapping("/books")
    public String listProducts(Model model){
        List list = bookAdService.listProducts();
        model.addAttribute("books", list);
        return "books";
    }

    @RequestMapping("/book/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        Book book = bookAdService.getProductById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @RequestMapping("/book/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookAdService.getProductById(id));
        return "bookform";
    }

    @RequestMapping("/book/new")
    public String newProduct(Model model){
        model.addAttribute("book", new Book());
        return "bookform";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String saveOrUpdate(Book book){
        Book p = bookAdService.saveOrUpdate(book);
        return "redirect:/book/" + book.getId();
    }

    @RequestMapping("/book/delete/{id}")
    public String delete(@PathVariable Integer id){
        bookAdService.delete(id);
        return "redirect:/book";
    }
}


