package com.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Date_of_account_creation")
    private LocalDate startDate;

    @OneToMany(
            targetEntity = Rents.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rents> rents =  new ArrayList<>();

    public User(String name, String lastName, LocalDate startDate) {
        this.name = name;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public User(int userId, String name, String lastName, LocalDate startDate) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.startDate = startDate;
    }
}
