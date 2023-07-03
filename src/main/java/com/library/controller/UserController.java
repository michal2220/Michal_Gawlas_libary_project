package com.library.controller;

import com.library.controller.exceptions.UserNotFoundException;
import com.library.dbService.mapper.UserMapper;
import com.library.dbService.service.UserDbService;
import com.library.domain.User;
import com.library.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    private final UserDbService userDbService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody  UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userDbService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) throws UserNotFoundException {
            return ResponseEntity.ok(userMapper.mapToUserDto(userDbService.getUser(userId)));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userDbService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }
}
