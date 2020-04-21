package com.pinhost.mm.dtcdatabase.repositories;

import com.pinhost.mm.dtcdatabase.config.DBConfig;
import com.pinhost.mm.dtcdatabase.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RoleRepositoryH2 {

    private DBConfig dbConfig;

    //@Autowired
    //@Qualifier("h2_template")
    private NamedParameterJdbcTemplate jdbcTemplate;

    //@Autowired
    private MapSqlParameterSource parameterSource;

    public RoleRepositoryH2() {
        this.dbConfig = new DBConfig();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(this.dbConfig.geSource());
        this.parameterSource = new MapSqlParameterSource();
    }

    public RoleModel getUserRoleByRoleId(Long roleId) {
        final String sql = "SELECT * FROM role where id = :id";
        parameterSource.addValue("id", roleId);
        return jdbcTemplate.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<>(RoleModel.class));
    }
}
