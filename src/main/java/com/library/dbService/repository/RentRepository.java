package com.library.dbService.repository;

import com.library.domain.Book;
import com.library.domain.Rents;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional
public interface RentRepository extends CrudRepository<Rents, Integer> {

    List<Rents> findAll();

    @Query
    void updateReturnDateByBookId(@Param("bookId") int bookId, @Param("returnDate")LocalDate returnDate);

    Rents findByBookBookId (int BookId);


}
