package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.AuthorController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.author.AuthorSearchDto;
import com.aleksandr0412.bookstore.annotations.Audit;
import com.aleksandr0412.bookstore.constants.AuditCode;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class AuthorControllerImpl implements AuthorController {
    private final AuthorService service;
    private static final Logger log = LoggerFactory.getLogger(AuthorControllerImpl.class.getName());

    public AuthorControllerImpl(AuthorService service) {
        this.service = service;
    }

    @Override
    public AuthorDto getAuthor(UUID id) {
        log.info("getAuthor with {} - start ", id);
        var result = service.getAuthorByPK(id);
        log.info("getUser end with {}, with result {}", id, result);
        return result;
    }

    @Override
    public PageDto<AuthorDto> getAuthors(@RequestBody Search<AuthorSearchDto> authorSearchDto) {
        log.info("getAuthor with {} - start ", authorSearchDto);
        var result = service.getAuthors(authorSearchDto);
        log.info("getUser end with {}, with result {}", authorSearchDto, result);
        return result;
    }

    @Audit(AuditCode.AUTHOR_CREATE)
    @Override
    public ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto, UriComponentsBuilder componentsBuilder) {
        log.info("createAuthor with {} - start ", authorDto);
        AuthorDto result = service.addAuthor(authorDto);
        URI uri = componentsBuilder.path("/api/author/" + result.getId()).buildAndExpand(result).toUri();
        log.info("createAuthor end with {}, with result {}", authorDto, result);

        return ResponseEntity.created(uri).body(result);
    }

    @Audit(AuditCode.AUTHOR_UPDATE)
    @Override
    public AuthorDto updateAuthor(UUID id, AuthorDto authorDto) {
        log.info("updateAuthor with {} - start ", authorDto);
        if (!authorDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }
        var result = service.updateAuthor(authorDto);
        log.info("updateAuthor end with {}, with result {}", authorDto, result);

        return result;
    }

    @Audit(AuditCode.AUTHOR_DELETE)
    @Override
    public AuthorDto deleteAuthor(UUID id) {
        log.info("deleteAuthor with {} - start ", id);
        var result = service.deleteAuthorByPK(id);
        log.info("updateAuthor end with {}, with result {}", id, result);

        return result;
    }


}
