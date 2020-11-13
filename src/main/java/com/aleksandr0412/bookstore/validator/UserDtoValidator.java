package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.controller.dto.UserDto;
import com.aleksandr0412.bookstore.exceptions.IncorrectEmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserDtoValidator {
    protected static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(AuthorDto.class.getName());

    public UserDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    protected static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public void validate(UserDto userForm) {
        if (userForm.getEmail().isEmpty() || userForm.getUsername().isEmpty()) {
            logger.error("user is empty");
            String message = messageSource.getMessage("user.exception", new Object[]{}, Locale.getDefault());
            throw new IllegalArgumentException(message);
        }
        if (validateEmail(userForm.getEmail())) {
            String message = messageSource.getMessage("email.exception", new Object[]{}, Locale.getDefault());
            throw new IncorrectEmailException(message);
        }
    }
}
