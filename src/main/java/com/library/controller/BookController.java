package com.library.controller;

import com.library.domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

@Controller
@Transactional
public interface BookController extends CrudRepository<Book, Integer> {
}
