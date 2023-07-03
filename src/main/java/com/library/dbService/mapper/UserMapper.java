package com.library.dbService.mapper;

import com.library.controller.exceptions.RentNotFoundException;
import com.library.dbService.service.RentDbService;
import com.library.domain.Rents;
import com.library.domain.User;
import com.library.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    private RentDbService rentDbService;

    public UserDto mapToUserDto(final User user) {
        return new UserDto (
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getStartDate(),
                user.getRents().stream().map(Rents::getRentId).collect(Collectors.toList())
        );
    }

    public User mapToUser(UserDto userDto) throws RentNotFoundException {
        return new User (
                userDto.getUserId(),
                userDto.getName(),
                userDto.getLastName(),
                userDto.getStartDate(),
                rentDbService.getAllRents().stream().filter(r->r.getUser().equals(userDto.getUserId())).collect(Collectors.toList())

        );
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
