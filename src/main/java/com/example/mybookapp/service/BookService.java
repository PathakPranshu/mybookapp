package com.example.mybookapp.service;

import com.example.mybookapp.entity.Author;
import com.example.mybookapp.entity.Book;
import com.example.mybookapp.repository.AuthorRepository;
import com.example.mybookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;
    
    @Autowired
    private AuthorRepository authorRepo;

    // Read
    public List<Book> getAllBooksJoined() {
        return bookRepo.findAllBooksWithAuthors();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    // Create & Update
    public void saveBook(Book book, Long authorId) {
        Author author = authorRepo.findById(authorId)
            .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);
        bookRepo.save(book);
    }
}