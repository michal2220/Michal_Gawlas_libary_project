package com.library.domain;

import jakarta.persistence.*;
import lombok.*;

@NamedQuery(
        name = "Book.getAvailableBooksOfTitle",
        query = "SELECT b FROM Book b " +
                "JOIN b.title t " +
                "WHERE t.titleId = :titleId " +
                "AND b.status = 'Free'"

)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int bookId;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rents rents;

    public Book(String status) {
        this.status = status;
    }


    public Book(int bookId, String status, Title title) {
        this.bookId = bookId;
        this.status = status;
        this.title = title;
    }
}
