package com.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Rents.updateReturnDateByBookId",
        query = "UPDATE Rents r " +
                "SET r.returnDate = :returnDate " +
                "WHERE r.book.bookId = :bookId"
)
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

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
