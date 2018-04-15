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

import javax.validation.constraints.Null;
import java.awt.print.Book;
import java.util.Comparator;
import java.util.List;

@Controller
public class BookAdController {

    private BookAdService bookAdService;
    private int i = 0;
    private List list;

    @Autowired
    public void setBookAdService(BookAdService bookAdService) {
        this.bookAdService = bookAdService;
    }

    @RequestMapping(value = "/books/{cat}", method = RequestMethod.GET)
    public String listBooks(@PathVariable("cat") String cat, Model model,
                            @RequestParam(value = "searchBar", required = false) String searchBy,
                            @RequestParam(value = "categories", required = false) String categories,
                            @RequestParam(value = "filterBy", required = false) String filterBy,
                            @RequestParam(value = "sortBy", required = false) String sortBy) {
        if ( i == 0) {
            list = bookAdService.listBooks("all", "");
            i = 2;
        }

        try {
            if (searchBy == null) {
                searchBy = new String("");
            }
        } catch (Exception e) {
        }

        if (sortBy != null) {
            if (sortBy.equals("author")) {
                list.sort((Comparator<BookAd>) (o1, o2) -> o1.getAuthor().compareTo(o2.getAuthor()));
            }
            else if (sortBy.equals("title")) {
                list.sort((Comparator<BookAd>) (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
            }
            else {
                list.sort((Comparator<BookAd>) (o1, o2) -> o1.getEdition().compareTo(o2.getEdition()));
            }
        }

        if (categories != null && categories.equals("all")) {
            list = bookAdService.listBooks(cat, new String(searchBy));
        } else {

            if (categories != null || filterBy != null) {
                list = bookAdService.applyFilter(filterBy, categories);
            } else {
                list = bookAdService.listBooks(cat, new String(searchBy));
            }
        }
        model.addAttribute("books", list);
        return "books";
    }

    @RequestMapping("/bookAd/{id}")
    public String getBook(@PathVariable("id") Integer id, Model model,
                          @RequestParam(value = "delete", required = false) String delete,
                          @RequestParam(value = "edit", required = false) String edit
    ) {

        if (edit == null && delete == null) {
            try {
                BookAd bookAd = bookAdService.getBookById(id);
                model.addAttribute("bookAd", bookAd);

            } catch (Exception e) {

                System.out.println("This book ad doesn't exist.");
            }
            return "bookAd";
        } else if (edit != null) {
            model.addAttribute("bookAd", bookAdService.getBookByHashKey(edit));
            if (model.asMap().get("bookAd") != null &&
                    bookAdService.verifyHash(id, edit))
                return "bookform";
            else {
                model.asMap().remove("bookAd");
                BookAd bookAd = bookAdService.getBookById(id);
                model.addAttribute("bookAd", bookAd);
                return "bookAd";
            }
        } else {
            try {
                if (bookAdService.verifyHash(id, delete))
                    bookAdService.delete(delete);
                else {
                    BookAd bookAd = bookAdService.getBookById(id);
                    model.addAttribute("bookAd", bookAd);
                    return "bookAd";
                }
            } catch (Exception e) {
            }
            return "redirect:/books/all";
        }
    }

    @RequestMapping("/bookAd/edit/{id}")
    public String edit(@PathVariable Integer id, Model model,
                       @RequestParam(value = "edit", required = true) String edit) {
        model.addAttribute("bookAd", bookAdService.getBookByHashKey(edit));
        return "bookform";
    }

    @RequestMapping("/bookAd/new")
    public String newProduct(Model model) {
        model.addAttribute("bookAd", new BookAd());
        return "bookform";
    }

    @RequestMapping(value = "/bookAd", method = RequestMethod.POST)
    public String saveOrUpdate(BookAd bookAd) {
        BookAd p = bookAdService.saveOrUpdate(bookAd);
        return "redirect:/bookAd/" + bookAd.getId();
    }

    /*@RequestMapping("/bookAd/delete/{id}")
    public String delete(@PathVariable Integer id){
        bookAdService.delete(id);
        return "redirect:/books";
    }*/

    @RequestMapping(value = "errors")
    public String errorHandler() {
        return "redirect:/error";
    }
}
