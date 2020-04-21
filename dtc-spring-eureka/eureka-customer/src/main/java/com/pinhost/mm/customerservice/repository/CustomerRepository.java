package com.pinhost.mm.customerservice.repository;

import com.pinhost.mm.customerservice.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    private static final Log LOG = LogFactory.getLog(CustomerRepository.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private MapSqlParameterSource parameterSource;

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
