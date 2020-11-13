package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.exceptions.EmptyOrderException;
import com.aleksandr0412.bookstore.exceptions.IncorrectSumException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class OrderDtoValidator {
    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(OrderDtoValidator.class.getName());

    public OrderDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(OrderDto orderForm) {
        if (orderForm.getBooks().isEmpty()) {
            logger.error("order is empty");
            String message = messageSource.getMessage("order.exception", new Object[]{}, Locale.getDefault());
            throw new EmptyOrderException(message);
        }
        if (orderForm.getBooks().stream().mapToLong(value -> value.getPrice().longValue()).sum() != orderForm.getPrice().longValue()) {
            String message = messageSource.getMessage("order.exception", new Object[]{}, Locale.getDefault());
            throw new IncorrectSumException(message);
        }
    }
}
