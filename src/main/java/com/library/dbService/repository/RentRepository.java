package com.library.dbService.repository;

import com.library.domain.Rents;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface RentRepository extends CrudRepository<Rents, Integer> {

    List<Rents> findAll();
}
