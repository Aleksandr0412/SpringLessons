package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.BookDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BookDtoValidator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(BookDto.class.getName());

    public BookDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(BookDto bookForm) {
        if (bookForm.getTitle().isEmpty() || bookForm.getPrice() == null) {
            logger.error("incorrect book");
            String message = messageSource.getMessage("book.exception", new Object[]{}, Locale.getDefault());
            throw new IllegalArgumentException(message);
        }
    }
}