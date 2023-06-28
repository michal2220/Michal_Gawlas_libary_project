package com.library.controller;

import com.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleController extends CrudRepository<Title, Integer> {
}
