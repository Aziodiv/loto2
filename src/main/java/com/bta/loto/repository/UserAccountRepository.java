package com.bta.loto.repository;

import com.bta.loto.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserAccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

    public int save(UserAccount userAccount) {
        final String sql = "INSERT INTO user_account (id, username, password, email, tax_number, first_name, last_name)" +
                "values (nextval('user_account_seq')," +
                ":username," +
                ":password," +
                ":email," +
                ":tax_number," +
                ":first_name," +
                ":last_name)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("username",userAccount.getUsername());
        map.addValue("password",userAccount.getPassword());
        map.addValue("email",userAccount.getEmail());
        map.addValue("tax_number",userAccount.getTaxNumber());
        map.addValue("first_name",userAccount.getFirstName());
        map.addValue("last_name",userAccount.getLastNmae());

        return nameParameterJdbcTemplate.update(sql,map);
    }


    public List<UserAccount> findAll() {
        return jdbcTemplate.query("SELECT * FROM USER_ACCOUNT", getRowMapper());

    }


    public List<UserAccount> findByUsername(String username) {
        String query = "SELECT * FROM USER_ACCOUNT where username= :username";


        MapSqlParameterSource map = new MapSqlParameterSource().addValue("username", username);
        map.addValue("username", username);

        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
    }


    private RowMapper<UserAccount> getRowMapper() {
        return new RowMapper() {
            @Override
            public UserAccount mapRow(ResultSet resultSet, int i) throws SQLException {
                return new UserAccount(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("tax_number"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"));

            }
        };

    }

}
