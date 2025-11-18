package com.example.mybookapp.controller;

import com.example.mybookapp.entity.Book;
import com.example.mybookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // READ: List all entities
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooksJoined());
        return "book-list";
    }

    // CREATE: Show Form
    @GetMapping("/add")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("listAuthors", bookService.getAllAuthors());
        return "book-form";
    }

    // CREATE: Save Data
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, @RequestParam("authorId") Long authorId, Model model) {
        try {
            bookService.saveBook(book, authorId);
            return "redirect:/";
        } catch (DataIntegrityViolationException e) {
            // Requirement: Handle integrity violations
            model.addAttribute("error", "Error: Book title must be unique or data is invalid.");
            model.addAttribute("listAuthors", bookService.getAllAuthors());
            return "book-form";
        }
    }

    // UPDATE: Show Form
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable(value = "id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("listAuthors", bookService.getAllAuthors());
        return "book-update";
    }

    // UPDATE: Save Changes
    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book, @RequestParam("authorId") Long authorId) {
        bookService.saveBook(book, authorId);
        return "redirect:/";
    }
}