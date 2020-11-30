package com.aleksandr0412.bookstore.controller;

import com.aleksandr0412.bookstore.controller.dto.AuthorDto;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable UUID id) {
        return service.getAuthorByPK(id);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto, UriComponentsBuilder componentsBuilder) {
        AuthorDto result = service.addAuthor(authorDto);
        URI uri = componentsBuilder.path("/api/author/" + result.getId()).buildAndExpand(result).toUri();

        return ResponseEntity.created(uri).body(result);
    }

    @PutMapping("{id}")
    public AuthorDto updateAuthor(@PathVariable UUID id, @RequestBody AuthorDto authorDto) {
        if (!authorDto.getId().equals(id)) {
            throw new ResourceNotFoundException("wrong id");
        }

        return service.updateAuthor(authorDto);
    }

    @DeleteMapping
    public AuthorDto deleteAuthor(@RequestParam(value = "id") UUID id) {
        return service.deleteAuthorByPK(id);
    }
}
