package com.library.controller;

import com.library.controller.exceptions.UserNotFoundException;
import com.library.dbService.mapper.UserMapper;
import com.library.dbService.service.UserDbService;
import com.library.domain.User;
import com.library.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
    public void createUser(@RequestBody  UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
    }

    @GetMapping
    public List<UserDto> getUsers() {
        List<User> users = userDbService.getAllUsers();
        return userMapper.mapToUserDtoList(users);
    }

    @GetMapping(value = "{userId}")
    public UserDto getUser(@PathVariable int userId) throws UserNotFoundException {

        return userMapper.mapToUserDto(
                userDbService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }
}
