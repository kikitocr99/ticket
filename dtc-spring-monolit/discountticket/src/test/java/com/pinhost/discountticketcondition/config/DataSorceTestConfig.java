package com.pinhost.discountticketcondition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSorceTestConfig {

    @Bean
    public DataSource geSource()
    {
        DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
        dmDataSource.setDriverClassName("org.h2.Driver");
        dmDataSource.setUrl("jdbc:h2:~/ticket;DB_CLOSE_ON_EXIT=FALSE");
        dmDataSource.setUsername("test");
        dmDataSource.setPassword("test");

        return dmDataSource;
    }
}
