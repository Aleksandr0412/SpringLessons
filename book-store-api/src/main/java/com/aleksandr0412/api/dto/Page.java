package com.aleksandr0412.api.dto;

/**
 * Класс для пагинации
 */
public class Page {
    /**
     * Номер страницы
     */
    int page;
    /**
     * Кол-во элементов страницы
     */
    int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
