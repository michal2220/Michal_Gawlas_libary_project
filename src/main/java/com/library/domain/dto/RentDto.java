package com.library.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class RentDto {

    private int rentId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private List<Integer> booksId = new ArrayList<>();
    private int userId;
}
