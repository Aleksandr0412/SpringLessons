package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.api.dto.book.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BookDtoValidator {
    private final MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(BookDtoValidator.class.getName());

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