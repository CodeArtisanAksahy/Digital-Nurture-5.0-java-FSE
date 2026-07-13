package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection - BookRepository injected");
    }

    // Setter injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection - BookRepository injected");
    }

    public List<String> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public String getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public void addBook(String book) {
        bookRepository.addBook(book);
    }
}
