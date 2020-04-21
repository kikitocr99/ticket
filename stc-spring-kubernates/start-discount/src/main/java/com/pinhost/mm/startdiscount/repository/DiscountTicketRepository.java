package com.pinhost.mm.startdiscount.repository;

import com.pinhost.mm.startdiscount.model.DiscountTicketCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountTicketRepository {

    @Autowired
    @Qualifier("sqltemplate")
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private MapSqlParameterSource parameterSource;

    public DiscountTicketCondition getDTCByName(String name) {

        final String sql = "SELECT * FROM discount_ticket_condition where name = :name";
        parameterSource.addValue("name", name);
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(DiscountTicketCondition.class)));
    }

    public List<DiscountTicketCondition> getAllDTCByCustomerId(final Integer customerId) {
        final String sql = "SELECT * FROM discount_ticket_condition where owner_id = :customerId";
        parameterSource.addValue("customerId", customerId);
        return jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(DiscountTicketCondition.class));
    }
}
