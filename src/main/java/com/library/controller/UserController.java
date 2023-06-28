package com.library.controller;

import com.library.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

@Controller
@Transactional
public interface UserController extends CrudRepository <User, Integer> {
}
