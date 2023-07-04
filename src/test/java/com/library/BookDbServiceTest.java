package com.library;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.dbService.repository.BookRepository;
import com.library.dbService.repository.TitleRepository;
import com.library.dbService.service.BookDbService;
import com.library.dbService.service.TitleDbService;
import com.library.domain.Book;
import com.library.domain.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDbServiceTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDbService bookDbService;
    @Autowired
    private TitleRepository titleRepository;

    @Test
    void getAllBooks() {
        //Given
        Book book = new Book();

        //When
        bookRepository.save(book);
        List<Book> books = bookDbService.getAllBooks();

        //Then
        Assertions.assertNotNull(books);

        //CleanUp
        bookRepository.deleteById(book.getBookId());
    }

    @Test
    void getBook() throws BookNotFoundException {
        //Given
        Book book = new Book();

        //When
        bookRepository.save(book);
        Book testBook = bookDbService.getBook(book.getBookId());

        //Then
        Assertions.assertEquals(book.getBookId(), testBook.getBookId());

        //CleanUp
        bookRepository.deleteById(book.getBookId());
    }

    @Test
    void getAvailableBooks() {
        //Given
        Book book1 = new Book("Free");
        Book book2 = new Book("Free");

        Title title = new Title();

        book1.setTitle(title);
        book2.setTitle(title);
        title.getBooks().add(book1);
        title.getBooks().add(book2);

        //When
        titleRepository.save(title);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> availableBooks = bookDbService.getAvailableBooks(title.getTitleId());

        //Then
        assertEquals(2, availableBooks.size());

        //CleanUp
        bookRepository.deleteById(book1.getBookId());
        bookRepository.deleteById(book2.getBookId());
        titleRepository.deleteById(title.getTitleId());
    }
}