package com.library.controller;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.controller.exceptions.TitleNotFoundException;
import com.library.dbService.mapper.BookMapper;
import com.library.dbService.service.BookDbService;
import com.library.domain.Book;
import com.library.domain.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookMapper bookMapper;
    private final BookDbService bookDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> getBooks(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        Book savedBook = bookDbService.saveBook(book);
        return ResponseEntity.ok(bookMapper.mapToBookDto(savedBook));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable int bookId) throws BookNotFoundException, TitleNotFoundException {
        return ResponseEntity.ok(bookMapper.mapToBookDto(bookDbService.getBook(bookId)));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookDbService.getAllBooks();
        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
    }
}
