package com.library.dbService.repository;

import com.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<Title, Integer> {
}
