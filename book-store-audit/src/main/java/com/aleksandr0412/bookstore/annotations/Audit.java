package com.aleksandr0412.bookstore.annotations;

import com.aleksandr0412.bookstore.constants.AuditCode;

import java.lang.annotation.*;

/**
 * Audit.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Audit {

    AuditCode value();

}
