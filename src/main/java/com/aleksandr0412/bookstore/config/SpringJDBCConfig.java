package com.aleksandr0412.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfig {

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    @DependsOn("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert authorSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert authorSimpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        authorSimpleJdbcInsert.withTableName("authors");
        return authorSimpleJdbcInsert;
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert bookSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert bookSimpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        bookSimpleJdbcInsert.withTableName("books");
        return bookSimpleJdbcInsert;
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert orderSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert orderSimpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        orderSimpleJdbcInsert.withTableName("orders");
        return orderSimpleJdbcInsert;
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert userSimpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert userSimpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        userSimpleJdbcInsert.withTableName("users");
        return userSimpleJdbcInsert;
    }

}
