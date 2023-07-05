package com.library.controller;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.controller.exceptions.RentNotFoundException;
import com.library.controller.exceptions.UserNotFoundException;
import com.library.dbService.mapper.RentMapper;
import com.library.dbService.service.RentDbService;
import com.library.domain.Rents;
import com.library.domain.dto.RentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rents")
@RequiredArgsConstructor
public class RentController {

    private final RentMapper rentMapper;
    private final RentDbService rentDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRent(@RequestBody RentDto rentDto) throws UserNotFoundException, BookNotFoundException {
        Rents rents = rentMapper.mapToRent(rentDto);
        rentDbService.saveRent(rents);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RentDto> updateRent (@RequestBody RentDto rentDto) throws UserNotFoundException, BookNotFoundException {
        Rents rents = rentMapper.mapToRent(rentDto);
        Rents savedRents = rentDbService.saveRent(rents);
        return ResponseEntity.ok(rentMapper.mapToRentDto(savedRents));
    }

    @PutMapping(value = "/bookReturn/{bookId}")
    public ResponseEntity<?> returnBook (@PathVariable int bookId, @RequestBody Rents rents) throws BookNotFoundException{
        Rents rentedBook = rentDbService.findByBookId(bookId);
        rentedBook.setReturnDate(rents.getReturnDate());
        Rents savedRents = rentDbService.saveRent(rentedBook);
        return ResponseEntity.ok(rentMapper.mapToRentDto(savedRents));
    }

    @GetMapping(value = "{rentsId}")
    public ResponseEntity<RentDto> getRent(@PathVariable int rentsId) throws RentNotFoundException {
        return ResponseEntity.ok(rentMapper.mapToRentDto(rentDbService.getRent(rentsId)));
    }

    @GetMapping(value = "/bookFind/{bookId}")
    public ResponseEntity<RentDto> getBookForRent(@PathVariable int bookId) throws RentNotFoundException {
        return ResponseEntity.ok(rentMapper.mapToRentDto(rentDbService.findByBookId(bookId)));
    }



    @GetMapping
    public ResponseEntity<List<RentDto>> getRents() {
        List<Rents> rentsList = rentDbService.getAllRents();
        return ResponseEntity.ok(rentMapper.mapToRentDtoList(rentsList));
    }
}
