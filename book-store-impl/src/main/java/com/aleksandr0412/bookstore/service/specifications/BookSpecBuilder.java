package com.aleksandr0412.bookstore.service.specifications;

import com.aleksandr0412.api.dto.book.BookSearchDto;
import com.aleksandr0412.bookstore.model.Book;
import com.aleksandr0412.bookstore.model.Genre;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BookSpecBuilder {
    public Specification<Book> getSpec(BookSearchDto bookSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (bookSearchDto.getGenre() != null) {
                predicates.add(root.get("genre").in(Genre.valueOf(bookSearchDto.getGenre())));
            }
            if (bookSearchDto.getAuthorId() != null) {
                predicates.add(root.get("author").get("id").in(bookSearchDto.getAuthorId()));
            }
            if (bookSearchDto.getTitle() != null) {
                predicates.add(root.get("title").in(bookSearchDto.getTitle()));
            }
            if (bookSearchDto.getMinPrice() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("price"), bookSearchDto.getMinPrice()));
            }
            if (bookSearchDto.getMaxPrice() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("price"), bookSearchDto.getMaxPrice()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
