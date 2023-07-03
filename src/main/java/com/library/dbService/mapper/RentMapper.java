package com.library.dbService.mapper;

import com.library.controller.exceptions.UserNotFoundException;
import com.library.dbService.service.BookDbService;
import com.library.dbService.service.UserDbService;
import com.library.domain.Book;
import com.library.domain.Rents;
import com.library.domain.dto.BookDto;
import com.library.domain.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentMapper {

    private BookDbService bookDbService;
    private UserDbService userDbService;

    public RentDto mapToRentDto(final Rents rents) {
        return new RentDto(
                rents.getRentId(),
                rents.getRentDate(),
                rents.getReturnDate(),
                rents.getBooks().stream().map(r->r.getBookId()).collect(Collectors.toList()),
                rents.getUser().getUserId()

        );
    }

    public Rents mapToRent (final RentDto rentDto) throws UserNotFoundException {
        return new Rents(
                rentDto.getRentId(),
                rentDto.getRentDate(),
                rentDto.getReturnDate(),
                bookDbService.getAllBooks(),
                userDbService.getUser(rentDto.getUserId())
        );
    }

    public List<RentDto> mapToRentDtoList (final List<Rents> rentList) {

        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
