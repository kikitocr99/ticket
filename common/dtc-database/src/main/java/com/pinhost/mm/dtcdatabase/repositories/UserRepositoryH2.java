package com.pinhost.mm.dtcdatabase.repositories;

import com.pinhost.mm.dtcdatabase.config.DBConfig;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryH2 {

   // @Autowired
    //@Qualifier("h2_template")
    private NamedParameterJdbcTemplate jdbcTemplate;

    private MapSqlParameterSource parameterSource;

    private DBConfig dbConfig = new DBConfig();

    public UserRepositoryH2() {
        jdbcTemplate = new NamedParameterJdbcTemplate(dbConfig.geSource());
        parameterSource = new MapSqlParameterSource();
    }

    public UserModel getUserByName(String name) {
        final String sql = "SELECT * FROM user where name = :name";
        parameterSource.addValue("name", name);
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(UserModel.class)));
    }

    public Long getUserIdByName(final String userName) {
        final String sql = "SELECT id FROM user where name = :name";
        parameterSource.addValue("name", userName);
        return jdbcTemplate.queryForObject(sql, parameterSource, Long.class);
    }

    public List<UserModel> getUserModelListByName(final String name){
        final String sql = "SELECT * FROM user where name like :name";
        parameterSource.addValue("name", "%" + name + "%");
        return jdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(UserModel.class));
    }

    public List<UserModel> getAllUsers(){
        final String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserModel.class));
    }
}
