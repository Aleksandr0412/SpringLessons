package com.aleksandr0412.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
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
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return namedParameterJdbcTemplate;
    }

    @Bean
    @DependsOn("dataSource")
    @Scope("prototype")
    public SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        return simpleJdbcInsert;
    }

}
