package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TitleDto {

    private int titleId;
    private String title;
    private String author;
    private int publicationYear;
}
