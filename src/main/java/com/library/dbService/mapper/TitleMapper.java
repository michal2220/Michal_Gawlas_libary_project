package com.library.dbService.mapper;

import com.library.domain.Title;
import com.library.domain.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleMapper {

    public TitleDto mapToTitleDto (final Title title){
        return new TitleDto (
                title.getTitleId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

    public Title mapToTitle(final TitleDto titleDto){
        return new Title(
                titleDto.getTitleId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }

    public List<TitleDto> mapToTitlesDtoList (final List<Title> titleList) {
        return titleList.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
