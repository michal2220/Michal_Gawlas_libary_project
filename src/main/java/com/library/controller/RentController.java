package com.library.controller;

import com.library.domain.Rents;
import org.springframework.data.repository.CrudRepository;

public interface RentController extends CrudRepository<Rents, Integer> {
}
