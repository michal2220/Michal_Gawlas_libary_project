package com.library.relationTests;

import com.library.controller.exceptions.RentNotFoundException;
import com.library.dbService.repository.BookRepository;
import com.library.dbService.repository.RentRepository;
import com.library.dbService.repository.TitleRepository;
import com.library.dbService.repository.UserRepository;
import com.library.dbService.service.RentDbService;
import com.library.domain.Book;
import com.library.domain.Rents;
import com.library.domain.Title;
import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RelationTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private RentDbService rentDbService;


    @Test
    public void userAndBookRelationWithRentTest() throws RentNotFoundException {
        //Given
        Book book = new Book();
        Title title = new Title();

        title.setTitle("BRAND NEW for relations");
        title.setAuthor("Author for relation testing");

        titleRepository.save(title);

        book.setStatus("free");

        bookRepository.save(book);

        title.getBooks().add(book);
        book.setTitle(title);

        titleRepository.save(title);
        bookRepository.save(book);

        User user = new User("BRAND NEW", "FOR TESTING", LocalDate.now());
        userRepository.save(user);

        Rents rents = new Rents();
        rents.setBook(book);
        rents.setUser(user);
        rents.setRentDate(LocalDate.now());

        rentRepository.save(rents);

        //When
        Rents testRent = rentDbService.getRent(rents.getRentId());
        int rentedBookId = testRent.getBook().getBookId();
        int rentedUserId = testRent.getUser().getUserId();

        //Then
        assertEquals(book.getBookId(),rentedBookId);
        assertEquals(user.getUserId(),rentedUserId);

        //CleanUp
        rentRepository.deleteById(rents.getRentId());
        userRepository.deleteById(user.getUserId());
        bookRepository.deleteById(book.getBookId());
        titleRepository.deleteById(title.getTitleId());
    }
}
