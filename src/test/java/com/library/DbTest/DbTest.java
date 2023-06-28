package com.library.DbTest;

import com.library.controller.UserController;
import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbTest {

    @Autowired
    private UserController userController;
    LocalDate localDate = LocalDate.of(2003,2,3);

    @Test
    public void userSaveTest() {
        //Given
        User user = new User("Michal", "Gawlas", localDate);

        //When
        userController.save(user);

        //Then
        int id = user.getUserId();
        Optional<User> readUser = userController.findById(id);
        assertTrue(readUser.isPresent());
    }
}
