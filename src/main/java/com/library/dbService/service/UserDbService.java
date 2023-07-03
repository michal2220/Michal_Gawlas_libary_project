package com.library.dbService.service;

import com.library.dbService.repository.UserRepository;
import com.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDbService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(int userId) {
        return userRepository.findById(userId);
    }

    public User saveUser (final User user){
        return userRepository.save(user);
    }
}
