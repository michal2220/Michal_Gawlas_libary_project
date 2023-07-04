package com.library.dbService.repository;

import com.library.domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

    @Query
    List <Book> getAvailableBooksOfTitle(@Param("titleId") int titleId);
}
