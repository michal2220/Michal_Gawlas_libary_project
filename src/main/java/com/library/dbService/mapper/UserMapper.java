package com.library.dbService.mapper;

import com.library.domain.User;
import com.library.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {


    public UserDto mapToUserDto(final User user) {
        return new UserDto (
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getStartDate()
        );
    }

    public User mapToUser(UserDto userDto) {
        return new User (
                userDto.getUserId(),
                userDto.getName(),
                userDto.getLastName(),
                userDto.getStartDate()
        );
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
