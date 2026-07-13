package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Spring in Action");
        books.add("Clean Code");
        books.add("Effective Java");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public String getBookById(int id) {
        if (id >= 0 && id < books.size()) {
            return books.get(id);
        }
        return null;
    }

    public void addBook(String book) {
        books.add(book);
    }
}
