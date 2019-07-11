package com.example.demo.config;

import com.example.demo.dao.FormDao;
import com.example.demo.dao.FormDaoImpl;
import com.example.demo.service.FormServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.boot.web.servlet.MultipartConfigFactory;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("128KB");
        return factory.createMultipartConfig();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/astin-test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public FormDao getUserDao() {
        return new FormDaoImpl(getJdbcTemplate());
    }

    @Bean
    public FormServiceImpl getFormService() {
        return new FormServiceImpl();
    }

}
