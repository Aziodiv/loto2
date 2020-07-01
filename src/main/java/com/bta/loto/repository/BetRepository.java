package com.bta.loto.repository;

import com.bta.loto.model.Bet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BetRepository extends AbstractRepository<Bet> {

    @Override
    public int save(Bet entity) {
        final String sql = "INSERT INTO bet (id, number1, number2, number3, number4, number5, number6," +
                "user_account_id, datetime, active)" +
                "values (nextval('bet_seq')," +
                ":number1," +
                ":number2," +
                ":number3," +
                ":number4," +
                ":number5," +
                ":number6," +
                ":user_account_id," +
                ":datetime," +
                ":active)";


        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("number1", entity.getNumber1());
        map.addValue("number2", entity.getNumber2());
        map.addValue("number3", entity.getNumber3());
        map.addValue("number4", entity.getNumber4());
        map.addValue("number5", entity.getNumber5());
        map.addValue("number6", entity.getNumber6());
        map.addValue("user_account_id", entity.getUserAccountId());
        map.addValue("datetime", entity.getDateTime());
        map.addValue("active", entity.isActive());

        return nameParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<Bet> findAll() {
        return jdbcTemplate.query("SELECT * FROM BET", getRowMapper());
    }

    public List<Bet> findAllActive(Boolean active) {
        String query = "SELECT * FROM BET where active = :active";
        MapSqlParameterSource map = new MapSqlParameterSource().addValue("active", active);
        map.addValue("active", active);
        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
    }



    private RowMapper<Bet> getRowMapper() {
        return new RowMapper() {
            @Override
            public Bet mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Bet(
                        resultSet.getLong("id"),
                        resultSet.getInt("number1"),
                        resultSet.getInt("number2"),
                        resultSet.getInt("number3"),
                        resultSet.getInt("number4"),
                        resultSet.getInt("number5"),
                        resultSet.getInt("number6"),
                        resultSet.getLong("user_account_id"),
                        resultSet.getTimestamp("datetime").toLocalDateTime(),
                        resultSet.getBoolean("active"));

            }
        };
    }
}


