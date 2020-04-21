package com.pinhost.mm.dtcdatabase.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    /*
    * Configuration für die Producthost Database
    * */
    @Bean("producthost")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:sqlserver://192.168.44.177;databaseName=producthost");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //return new DriverManagerDataSource();
        return dataSource;
    }

    /*
    *  Configuration für die Management Database
    * */
    @Bean("management")
    public DataSource devDataSource() {
        DriverManagerDataSource dmDataSource = new DriverManagerDataSource();

        dmDataSource.setUrl("jdbc:sqlserver://192.168.44.177;databaseName=management");
        dmDataSource.setUsername("sa");
        dmDataSource.setPassword("sa");
        dmDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return dmDataSource;
    }

    @Bean("h2_memory_db")
    public DataSource geSource()
    {
        DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
        dmDataSource.setDriverClassName("org.h2.Driver");
        dmDataSource.setUrl("jdbc:h2:~/ticket;DB_CLOSE_ON_EXIT=FALSE");
        dmDataSource.setUsername("test");
        dmDataSource.setPassword("test");

        return dmDataSource;
    }

    @Bean("producthost_template")
    public NamedParameterJdbcTemplate jdbcTemplate(@Qualifier("producthost") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean("management_template")
    public NamedParameterJdbcTemplate sqlDataSource(@Qualifier("management") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean("h2_template")
    public  NamedParameterJdbcTemplate geJdbcTemplate(@Qualifier("h2_memory_db")DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public MapSqlParameterSource parameterSource() {
        return new MapSqlParameterSource();
    }
}
