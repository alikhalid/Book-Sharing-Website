package edu.mwsu.springframework.bookshare.controller;

import edu.mwsu.springframework.bookshare.domain.BookAd;
import edu.mwsu.springframework.bookshare.service.BookAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookAdController {

    private BookAdService bookAdService;

    @Autowired
    public void setBookAdService(BookAdService bookAdService) {
        this.bookAdService = bookAdService;
    }

    @RequestMapping(value = "/books/{filter}", method = RequestMethod.GET)
    public String listBooks(@PathVariable("filter") String filter, Model model,
                            @RequestParam(value = "searchBar", required = false) String searchBy ){
        try {
            if (searchBy == null){
                searchBy = new String("");
            }
        } catch (Exception e) {}

        List list = bookAdService.listBooks(filter, new String(searchBy));

        model.addAttribute("books", list);
        return "books";
    }

    @RequestMapping("/bookAd/{id}")
    public String getBook(@PathVariable Integer id, Model model){
        BookAd bookAd = bookAdService.getBookById(id);
        model.addAttribute("bookAd", bookAd);
        return "bookAd";
    }

    @RequestMapping("/bookAd/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("bookAd", bookAdService.getBookById(id));
        return "bookform";
    }

    @RequestMapping("/bookAd/new")
    public String newProduct(Model model){
        model.addAttribute("bookAd", new BookAd());
        return "bookform";
    }

    @RequestMapping(value = "/bookAd", method = RequestMethod.POST)
    public String saveOrUpdate(BookAd bookAd){
        BookAd p = bookAdService.saveOrUpdate(bookAd);
        return "redirect:/bookAd/" + bookAd.getId();
    }

    @RequestMapping("/bookAd/delete/{id}")
    public String delete(@PathVariable Integer id){
        bookAdService.delete(id);
        return "redirect:/books";
    }
}


