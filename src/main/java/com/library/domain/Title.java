package com.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Title {

    @Id
    @GeneratedValue
    private int titleId;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private int publicationYear;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();


    public Title(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Title() {

    }

    public Title(int titleId, String title, String author, int publicationYear) {
        this.titleId = titleId;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
