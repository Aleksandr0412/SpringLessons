package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.api.controller.AuthorController;
import com.aleksandr0412.api.dto.PageDto;
import com.aleksandr0412.api.dto.Search;
import com.aleksandr0412.api.dto.author.AuthorDto;
import com.aleksandr0412.api.dto.author.AuthorSearchDto;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class AuthorControllerImpl implements AuthorController {
    private final AuthorService service;

    public AuthorControllerImpl(AuthorService service) {
        this.service = service;
    }

    @Override
    public AuthorDto getAuthor(UUID id) {
        return service.getAuthorByPK(id);
    }

    @Override
    public PageDto<AuthorDto> getAuthors(@RequestBody Search<AuthorSearchDto> authorSearchDto) {
        var result = service.getAuthors(authorSearchDto);
        return result;
    }

    @Override
    public ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto, UriComponentsBuilder componentsBuilder) {
        AuthorDto result = service.addAuthor(authorDto);
        URI uri = componentsBuilder.path("/api/author/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @Override
    public AuthorDto updateAuthor(UUID id, AuthorDto authorDto) {
        if (!authorDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }

        return service.updateAuthor(authorDto);
    }

    @Override
    public AuthorDto deleteAuthor(UUID id) {
        return service.deleteAuthorByPK(id);
    }


}
