package com.library.domain.dto;

import com.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {

    private int bookId;
    private String status;
    private int titleId;
}
