package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Library Management Application ===");
        System.out.println();

        // Load Spring Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get BookService bean (tests DI)
        BookService bookService = context.getBean(BookService.class);

        // Exercise 1 & 2: Test DI - Get all books
        System.out.println("--- Exercise 1 & 2: Testing Dependency Injection ---");
        List<String> books = bookService.getAllBooks();
        System.out.println("All Books: " + books);

        // Exercise 7: Test getting book by ID
        System.out.println();
        System.out.println("--- Exercise 7: Testing Constructor & Setter Injection ---");
        String book = bookService.getBookById(0);
        System.out.println("Book at index 0: " + book);

        // Exercise 3 & 8: Test AOP - adding a book triggers logging
        System.out.println();
        System.out.println("--- Exercise 3 & 8: Testing AOP Logging ---");
        bookService.addBook("Design Patterns");
        System.out.println("Books after adding: " + bookService.getAllBooks());

        System.out.println();
        System.out.println("=== Application completed successfully ===");

        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
