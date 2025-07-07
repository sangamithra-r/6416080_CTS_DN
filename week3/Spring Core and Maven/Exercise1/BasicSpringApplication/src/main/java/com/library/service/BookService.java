package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void displayBookTitle() {
        String title = bookRepository.getBookTitle();
        System.out.println("Book title: " + title);
    }
}
