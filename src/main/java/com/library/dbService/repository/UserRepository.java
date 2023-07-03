package com.library.dbService.repository;

import com.library.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository <User, Integer> {

    List<User> findAll();

    Optional<User> findById(int userId);

    User save(User user);


}
