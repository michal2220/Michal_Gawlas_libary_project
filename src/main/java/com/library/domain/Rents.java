package com.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Rents {

    @Id
    @GeneratedValue
    private int rentId;

    @Column
    private LocalDate rentDate;

    @Column
    private LocalDate returnDate;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "rents",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
