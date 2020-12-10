package com.aleksandr0412.bookstore.model;

import com.aleksandr0412.bookstore.model.listener.EntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AbstractEntity implements Identified<UUID> {

    /**
     * Дата создания
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * Дата обновления
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
