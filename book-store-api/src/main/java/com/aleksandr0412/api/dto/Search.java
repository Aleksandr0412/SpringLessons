package com.aleksandr0412.api.dto;

/**
 * Класс для поиска
 */
public class Search<T> {
    /**
     * Дто по которой осуществляется поиск
     */
    private T data;
    /**
     * Информация для пагинации
     */
    private Page page;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
