package com.aleksandr0412.bookstore.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SwaggerProperties.
 *
 * @author Ilya_Sukhachev
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * Название проекта
     */
    private String title;

    /**
     * Описание
     */
    private String description;

    /**
     * Контактное лицо
     */
    private Contact contact = new Contact();

    public SwaggerProperties() {
    }

    public SwaggerProperties(String title, String description, Contact contract) {
        this.title = title;
        this.description = description;
        this.contact = contract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public static class Contact {

        private String name;

        private String url;

        private String mail;

        public Contact(String name, String url, String mail) {
            this.name = name;
            this.url = url;
            this.mail = mail;
        }

        public Contact() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }
    }
}
