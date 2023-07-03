package com.library.controller;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.controller.exceptions.TitleNotFoundException;
import com.library.dbService.mapper.TitleMapper;
import com.library.dbService.service.TitleDbService;
import com.library.domain.Title;
import com.library.domain.dto.TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleMapper titleMapper;
    private final TitleDbService titleDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TitleDto> updateTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        Title savedTitle = titleDbService.saveTitle(title);
        return ResponseEntity.ok(titleMapper.mapToTitleDto(savedTitle));
    }

    @GetMapping(value = "{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable int titleId) throws BookNotFoundException {
        return ResponseEntity.ok(titleMapper.mapToTitleDto(titleDbService.getTitle(titleId)));
    }

    @GetMapping
    public ResponseEntity<List<TitleDto>> getTitles() {
        List<Title> titles = titleDbService.getAllTitles();
        return ResponseEntity.ok(titleMapper.mapToTitlesDtoList(titles));
    }

}
