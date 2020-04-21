package com.pinhost.mm.startdiscount.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("sqlsdbc")
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

    @Bean(name = "sqltemplate")
    public NamedParameterJdbcTemplate sqlDataSource(@Qualifier("sqlsdbc") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Bean
    public MapSqlParameterSource parameterSource() {
        return new MapSqlParameterSource();
    }

}
