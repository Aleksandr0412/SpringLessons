package com.aleksandr0412.bookstore.service;

import com.aleksandr0412.bookstore.dao.AuthorDAO;
import com.aleksandr0412.bookstore.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Author addAuthor(Author author) {
        return authorDAO.save(author);
    }

    public Author getAuthorByPK(Long id) {
        return authorDAO.getByPK(id);
    }

    public Author deleteAuthorByPK(Long id) {
        return authorDAO.deleteByPK(id);
    }

    public Author updateAuthor(Author author) {
        return authorDAO.update(author);
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authorDAO.getAll());
    }

}
