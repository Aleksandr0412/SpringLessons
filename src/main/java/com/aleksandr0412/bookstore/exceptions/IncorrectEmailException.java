package com.aleksandr0412.bookstore.exceptions;

public class IncorrectEmailException extends RuntimeException{
    public IncorrectEmailException(String message) {
        super(message);
    }
}
