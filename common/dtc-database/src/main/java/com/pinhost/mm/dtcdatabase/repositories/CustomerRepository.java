package com.pinhost.mm.dtcdatabase.repositories;

import com.pinhost.mm.dtcdatabase.config.DBConfig;
import com.pinhost.mm.dtcdatabase.model.Customer;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource parameterSource;

    private DBConfig dbConfig;

    public CustomerRepository() {
        this.dbConfig = new DBConfig();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(this.dbConfig.getDataSource());
        this.parameterSource = new MapSqlParameterSource();
    }

    public Customer getCustomerByName(String name) {
        //MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        final String sql = "SELECT * FROM customer where name = :name";
        parameterSource.addValue("name", name);
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(Customer.class)));
    }

    public Customer getCustomerById(Integer id) {
        final String sql = "SELECT * FROM customer where id = :id";
        parameterSource.addValue("id", id);

        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(Customer.class)));
    }

    public Customer getCustomerByUserId(final Long userId) {
        final String sql = "SELECT top 1 customer_id FROM link_customer_user WHERE user_id= :userId";
        parameterSource.addValue("userId", userId);

        Integer customerId = jdbcTemplate.queryForObject(sql, parameterSource, Integer.class);
        return getCustomerById(customerId);
    }
}
