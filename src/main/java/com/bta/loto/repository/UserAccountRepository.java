package com.bta.loto.repository;

import com.bta.loto.model.UserAccount;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserAccountRepository extends AbstractRepository<UserAccount> {
    @Override
    public int save(UserAccount entity) {
        final String sql = "INSERT INTO user_account (id, username, password, email, tax_number, first_name, last_name)" +
                "values (nextval('user_account_seq')," +
                ":username," +
                ":password," +
                ":email," +
                ":tax_number," +
                ":first_name," +
                ":last_name)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("username", entity.getUsername());
        map.addValue("password", entity.getPassword());
        map.addValue("email", entity.getEmail());
        map.addValue("tax_number", entity.getTaxNumber());
        map.addValue("first_name", entity.getFirstName());
        map.addValue("last_name", entity.getLastName());

        return nameParameterJdbcTemplate.update(sql, map);
    }


    public List<UserAccount> findAll() {
        return jdbcTemplate.query("SELECT * FROM USER_ACCOUNT", getRowMapper());

    }

/////////////////
    public List<UserAccount> findByEmail(String email) {
        String query = "SELECT * FROM USER_ACCOUNT where email = :email";
        MapSqlParameterSource map = new MapSqlParameterSource().addValue("email", email);
        map.addValue("email", email);
        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
    }



    public List<UserAccount> findByTaxNumber(Long taxNumber) {
        String query = "SELECT * FROM USER_ACCOUNT where tax_number = :tax_number";
        MapSqlParameterSource map = new MapSqlParameterSource().addValue("tax_number", taxNumber);
        map.addValue("tax_number", taxNumber);
        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
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
