package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AuthorDtoValidator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(AuthorDtoValidator.class.getName());

    public AuthorDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(AuthorDto authorForm) {
        if (authorForm.getName().isEmpty()) {
            logger.error("authorName is empty");
            String message = messageSource.getMessage("author.exception", new Object[]{}, Locale.getDefault());
            throw new IllegalArgumentException(message);
        }
    }
}
