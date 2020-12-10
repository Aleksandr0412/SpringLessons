package com.aleksandr0412.bookstore.model.listener;

import com.aleksandr0412.bookstore.model.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AbstractEntityListener {

    @PrePersist
    private void setCreateAt(final AbstractEntity entity) {
        LocalDateTime currentTime = LocalDateTime.now();
        entity.setCreatedAt(currentTime);
        entity.setUpdatedAt(currentTime);
    }

    @PreUpdate
    private void setUpdateAt(final AbstractEntity entity) {
        entity.setUpdatedAt(LocalDateTime.now());
    }

}
