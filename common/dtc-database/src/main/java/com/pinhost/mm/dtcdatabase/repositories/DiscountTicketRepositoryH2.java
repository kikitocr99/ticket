package com.pinhost.mm.dtcdatabase.repositories;

import com.pinhost.mm.dtcdatabase.config.DBConfig;
import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountTicketRepositoryH2 {
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource parameterSource;

    private DBConfig dbConfig;

    public DiscountTicketRepositoryH2() {
        this.dbConfig = new DBConfig();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(this.dbConfig.geSource());
        this.parameterSource = new MapSqlParameterSource();
    }

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
