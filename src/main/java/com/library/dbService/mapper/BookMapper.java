package com.library.dbService.mapper;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.controller.exceptions.TitleNotFoundException;
import com.library.dbService.service.BookDbService;
import com.library.dbService.service.TitleDbService;
import com.library.domain.Book;
import com.library.domain.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookMapper {

    private final TitleDbService titleDbService;

    public BookDto mapToBookDto (final Book book) {
        return new BookDto (
                book.getBookId(),
                book.getStatus(),
                book.getTitle().getTitleId()
        );
    }

    public Book mapToBook (final BookDto bookDto) throws BookNotFoundException {
        return new Book(
                bookDto.getBookId(),
                bookDto.getStatus(),
                titleDbService.getTitle(bookDto.getTitleId())
        );
    }

    public List<BookDto> mapToBookDtoList (final List<Book> books){
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
