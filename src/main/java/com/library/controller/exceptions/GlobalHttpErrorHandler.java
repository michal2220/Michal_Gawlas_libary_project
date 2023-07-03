package com.library.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException (UserNotFoundException exception) {
        return new ResponseEntity<>("User with such id does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException exception){
        return new ResponseEntity<>("Such title does not exist", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception){
        return new ResponseEntity<>("Such book does not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentNotFoundException.class)
    public ResponseEntity<Object> handleRentNotFoundException(RentNotFoundException exception){
        return new ResponseEntity<>("Such rent does not exist", HttpStatus.BAD_REQUEST);
    }


}