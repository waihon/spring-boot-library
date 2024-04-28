package com.waihon.luv2code.springbootlibrary.controller;

import com.waihon.luv2code.springbootlibrary.entity.Book;
import com.waihon.luv2code.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "testuser2@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }
}
