package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.UserController;
import com.aleksandr0412.api.dto.user.UserDto;
import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class UserControllerImpl implements UserController {
    private final UserService service;
    private static final Logger log = LoggerFactory.getLogger(UserControllerImpl.class.getName());

    public UserControllerImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDto getUserByPK(UUID id) {
        log.info("getUser with {} - start ", id);
        var result = service.getUserByPK(id);
        log.info("getUser end with {}, with result {}", id, result);

        return result;
    }

    @Audit(AuditCode.USER_CREATE)
    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto, UriComponentsBuilder componentsBuilder) {
        log.info("createUSer with {} - start ", userDto);
        UserDto result = service.createUser(userDto);
        URI uri = componentsBuilder.path("/api/book/" + result.getId()).buildAndExpand(result).toUri();
        log.info("createUser end with {}, with result {}", userDto, result);

        return ResponseEntity.created(uri).body(result);
    }

    @Audit(AuditCode.USER_DELETE)
    @Override
    public UserDto deleteUser(UUID id) {
        log.info("deleteUSer with {} - start ", id);
        var result = service.deleteUserByPK(id);
        log.info("deleteUser end with {}, with result {}", id, result);

        return result;
    }
}
