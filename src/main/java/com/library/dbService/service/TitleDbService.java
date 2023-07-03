package com.library.dbService.service;

import com.library.controller.exceptions.TitleNotFoundException;
import com.library.dbService.repository.TitleRepository;
import com.library.domain.Title;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TitleDbService  {

    private final TitleRepository titleRepository;

    public Title saveTitle (final Title title){
        return titleRepository.save(title);
    }

    public Title getTitle(final int titleId) throws TitleNotFoundException{
        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

    public List<Title> getAllTitles(){
        return titleRepository.findAll();
    }
}
