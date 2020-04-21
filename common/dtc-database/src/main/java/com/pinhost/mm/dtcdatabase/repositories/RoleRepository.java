package com.pinhost.mm.dtcdatabase.repositories;

import com.pinhost.mm.dtcdatabase.config.DBConfig;
import com.pinhost.mm.dtcdatabase.model.RoleModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource parameterSource;

    private DBConfig dbConfig;

    public RoleRepository() {
        this.dbConfig = new DBConfig();
        this.jdbcTemplate = new NamedParameterJdbcTemplate(this.dbConfig.devDataSource());
        this.parameterSource = new MapSqlParameterSource();
    }

    public RoleModel getUserRoleByRoleId(Long roleId) {
        final String sql = "SELECT * FROM role where id = :id";
        parameterSource.addValue("id", roleId);
        return jdbcTemplate.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<>(RoleModel.class));
    }
}
