package com.example.mybookapp.util;
import com.example.mybookapp.entity.Author;
import com.example.mybookapp.entity.Book;
import com.example.mybookapp.repository.AuthorRepository;
import com.example.mybookapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public DataSeeder(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authorRepo.count() == 0){
            Author a1 = authorRepo.save(new Author("Tulsidas", "das.tusli@saket.com"));
            Author a2 = authorRepo.save(new Author("R. K. Narayan", "narayan.rk@malgudi.com"));

            // Create 10 books
            for (int i = 1; i <= 5; i++) {
                bookRepo.save(new Book("Ramcharitmanas Vol " + i, 45.00 + i, a1));
                bookRepo.save(new Book("Malgudi Days " + i, 78.00 + i, a2));
            }
            System.out.println("\n\n--- Database Populated with 10 Rows ---\n\n");
        }
    }
}