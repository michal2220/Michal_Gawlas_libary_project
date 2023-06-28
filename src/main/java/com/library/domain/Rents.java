package com.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Rents {

    @Id
    @GeneratedValue
    private int rentId;

    @Column
    private int bookId;

    @Column
    private int userId;

    @Column
    private LocalDate rentDate;

    @Column
    private LocalDate returnDate;
}
