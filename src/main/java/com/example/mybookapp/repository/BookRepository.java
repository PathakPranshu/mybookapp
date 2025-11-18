package com.example.mybookapp.repository;

import com.example.mybookapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Requirement: Custom Query method performing Inner Join
    @Query("SELECT b FROM Book b JOIN b.author a ORDER BY b.id")
    List<Book> findAllBooksWithAuthors();
}