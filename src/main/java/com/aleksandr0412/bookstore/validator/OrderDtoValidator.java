package com.aleksandr0412.bookstore.validator;

import com.aleksandr0412.bookstore.controller.dto.OrderDto;
import com.aleksandr0412.bookstore.exceptions.EmptyOrderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class OrderDtoValidator {
    private final MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(OrderDtoValidator.class.getName());

    public OrderDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(OrderDto orderForm) {
        if (orderForm.getBookIds().isEmpty()) {
            logger.error("order is empty");
            String message = messageSource.getMessage("order.exception", new Object[]{}, Locale.getDefault());
            throw new EmptyOrderException(message);
        }
        if (orderForm.getPrice() == null) {
            String message = messageSource.getMessage("order.exception", new Object[]{}, Locale.getDefault());
            throw new EmptyOrderException(message);
        }
    }
}
