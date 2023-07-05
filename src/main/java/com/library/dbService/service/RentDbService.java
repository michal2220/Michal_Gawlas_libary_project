package com.library.dbService.service;

import com.library.controller.exceptions.RentNotFoundException;
import com.library.dbService.repository.RentRepository;
import com.library.domain.Book;
import com.library.domain.Rents;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RentDbService {

    private final RentRepository rentRepository;

    public List<Rents> getAllRents() {
        return rentRepository.findAll();
    }

    public Rents getRent(final int rentId) throws RentNotFoundException {
        return rentRepository.findById(rentId).orElseThrow(RentNotFoundException::new);
    }

    public Rents saveRent(final Rents rents){
        return rentRepository.save(rents);
    }

    public void returnBook(final int bookId, final LocalDate returnDate) {
        rentRepository.updateReturnDateByBookId(bookId,returnDate);
    }

    public Rents findByBookBookId(final int bookId) {
        return rentRepository.findByBookBookId(bookId);
    }


}
