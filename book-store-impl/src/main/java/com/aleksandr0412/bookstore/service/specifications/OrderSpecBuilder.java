package com.aleksandr0412.bookstore.service.specifications;

import com.aleksandr0412.api.dto.order.OrderSearchDto;
import com.aleksandr0412.bookstore.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderSpecBuilder {
    public Specification<Order> getSpec(OrderSearchDto orderSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (orderSearchDto.getUserId() != null) {
                predicates.add(root.get("user").get("id").in(orderSearchDto.getUserId()));
            }
            if (orderSearchDto.getMinPrice() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("price"), orderSearchDto.getMinPrice()));
            }
            if (orderSearchDto.getMaxPrice() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("price"), orderSearchDto.getMaxPrice()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
