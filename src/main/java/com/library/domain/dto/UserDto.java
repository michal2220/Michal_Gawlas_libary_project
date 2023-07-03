package com.library.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private int userId;

    private String name;

    private String lastName;

    private LocalDate startDate;

    private List<Integer> rentList = new ArrayList<>();

}
