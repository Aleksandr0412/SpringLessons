package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.exceptions.IncorrectEmailException;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserDtoValidator {
    private final MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(UserDtoValidator.class.getName());

    public UserDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    protected static boolean validateEmail(String emailStr) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(emailStr.trim());
    }

    public void validate(UserDto userForm) {
        if (userForm.getEmail().isEmpty() || userForm.getUsername().isEmpty()) {
            logger.error("user is empty");
            String message = messageSource.getMessage("user.exception", new Object[]{}, Locale.getDefault());
            throw new IllegalArgumentException(message);
        }
        if (!validateEmail(userForm.getEmail())) {
            String message = messageSource.getMessage("email.exception", new Object[]{}, Locale.getDefault());
            throw new IncorrectEmailException(message);
        }
    }
}
