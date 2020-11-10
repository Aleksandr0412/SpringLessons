package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.exceptions.ResourceNotFoundException;
import com.aleksandr0412.bookstore.model.Author;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorService {
    private AuthorDAO authorDAO;

    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Author addAuthor(Author author) {
        return authorDAO.save(author);
    }

    public Author getAuthorByPK(Long id) {
        Author author;
        if ((author = authorDAO.getByPK(id)) != null) {
            return author;
        } else throw new ResourceNotFoundException("Author not found");
    }

    public Author deleteAuthorByPK(Long id) {
        if (authorDAO.getByPK(id) != null) {
            return authorDAO.deleteByPK(id);
        } else throw new ResourceNotFoundException("Author not found");
    }

    public Author updateAuthor(Author author) {
        return authorDAO.update(author);
    }

    public Author deleteAuthor(Author author) {
        if (authorDAO.getByPK(author.getId()) != null) {
            return authorDAO.delete(author);
        } else throw new ResourceNotFoundException("Author not found");
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authorDAO.getAll());
    }

    public List<Author> addAllAuthors(Collection<Author> authors) {
        return new ArrayList<>(authorDAO.addAll(authors));
    }
}
