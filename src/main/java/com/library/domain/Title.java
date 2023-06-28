package com.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
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

}
