package com.jangjangyi.demospring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


public class BookService {
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setCreated(new Date());
        book.setBookStatus(BookStatus.DRAFT);
        return bookRepository.save(book);
    }

}
