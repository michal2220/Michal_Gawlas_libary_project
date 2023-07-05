/*
package com.library.relationTests;

import com.library.dbService.repository.BookRepository;
import com.library.dbService.repository.RentRepository;
import com.library.dbService.repository.TitleRepository;
import com.library.dbService.repository.UserRepository;
import com.library.dbService.service.BookDbService;
import com.library.domain.Book;
import com.library.domain.Rents;
import com.library.domain.Title;
import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EntityRelationTests {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookDbService bookDbService;

    @Test
    public void bookRelationWithTitleTest() {
        //Given
        Book book1 = new Book("rented");
        Book book2 = new Book("available");
        Title title = new Title("Title", "Author", 1996);

        book1.setTitle(title);
        book2.setTitle(title);
        title.getBooks().add(book1);
        title.getBooks().add(book2);

        //When
        titleRepository.save(title);

        //Then
        assertEquals(2, title.getBooks().size());

        //CleanUp
        titleRepository.deleteById(title.getTitleId());
    }

    @Test
    public void bookRelationWithRentTest() {
        //Given
        Book book1 = new Book("rented");
        Book book2 = new Book("available");
        Rents rent1 = new Rents();

        book1.setRents(rent1);
        book2.setRents(rent1);
        rent1.getBooks().add(book1);
        rent1.getBooks().add(book2);

        //When
        rentRepository.save(rent1);

        //Then
        assertEquals(2, rent1.getBooks().size());

        //CleanUp
        titleRepository.deleteById(rent1.getRentId());
        bookRepository.deleteById(book1.getBookId());
        bookRepository.deleteById(book2.getBookId());
        rentRepository.deleteById(rent1.getRentId());
    }

    @Test
    public void UserRelationWithRentTest() {
        //Given
        Rents rent1 = new Rents();
        User user1 = new User();

        rent1.setUser(user1);
        user1.getRents().add(rent1);

        //When
        userRepository.save(user1);

        //Then
        assertEquals(1, user1.getRents().size());

        //CleanUp
        rentRepository.deleteById(rent1.getRentId());
        userRepository.deleteById(user1.getUserId());

    }


    @Test
    public void AllRelationsTest() {
        //Given
        Book book1 = new Book("NEW STATUS");
        Book book2 = new Book("available");
        Rents rent1 = new Rents();
        Title title = new Title("Title", "Author", 1996);
        User user1 = new User();

        book1.setRents(rent1);
        book2.setRents(rent1);
        rent1.setUser(user1);

        //When

        userRepository.save(user1);
        rentRepository.save(rent1);
        titleRepository.save(title);
        bookRepository.save(book1);
        bookRepository.save(book2);

        //Then
        assertNotNull(titleRepository.findAll());

        //CleanUp
        bookRepository.deleteById(book1.getBookId());
        bookRepository.deleteById(book2.getBookId());
        titleRepository.deleteById(title.getTitleId());
        rentRepository.deleteById(rent1.getRentId());
        userRepository.deleteById(user1.getUserId());
    }
}
*/
