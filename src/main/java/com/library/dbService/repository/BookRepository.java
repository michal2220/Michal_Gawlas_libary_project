package com.library.dbService.repository;

import com.library.domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Integer> {
}
