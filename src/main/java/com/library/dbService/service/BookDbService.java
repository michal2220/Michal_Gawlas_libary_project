package com.library.dbService.service;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.dbService.repository.BookRepository;
import com.library.domain.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(final int bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }


}
