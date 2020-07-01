package com.bta.loto.repository;

import com.bta.loto.model.Bet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

package com.bta.loto.repository;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bta.loto.model.Bet;

@Repository
public class BetRepository extends AbstractRepository<Bet> {

    @Override
    public int save(Bet bet) {
        final String sql = "INSERT INTO bet (id, number1, number2, number3, number4, number5, number6, " +
                "user_account_id, datetime, active) " +
                "values (NEXTVAL('bet_seq'), " +
                ":number1," +
                ":number2," +
                ":number3," +
                ":number4," +
                ":number5," +
                ":number6," +
                ":user_account_id," +
                ":datetime," +
                ":active)";

        return namedParameterJdbcTemplate.update(sql, getMap(bet));
    }
    @Override
    public int update(Bet bet) {
        final String sql = "UPDATE bet SET " +
                "number1 = :number1," +
                "number2= :number2," +
                "number3= :number3," +
                "number4= :number4," +
                "number5= :number5," +
                "number6= :number6," +
                "user_account_id= :user_account_id," +
                "datetime = :datetime," +
                "active= :active " +
                "WHERE id = :id ";

        return namedParameterJdbcTemplate.update(sql, getMap(bet));
    }

    private MapSqlParameterSource getMap(Bet bet) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("number1", bet.getNumber1());
        map.addValue("number2", bet.getNumber2());
        map.addValue("number3", bet.getNumber3());
        map.addValue("number4", bet.getNumber4());
        map.addValue("number5", bet.getNumber5());
        map.addValue("number6", bet.getNumber6());
        map.addValue("user_account_id", bet.getUserAccountId());
        map.addValue("datetime", bet.getDateTime());
        map.addValue("active", bet.isActive());

        return map;
    }

    @Override
    public List<Bet> findAll() {
        return jdbcTemplate.query("SELECT * FROM bet", getRowMapper());
    }

    public List<Bet> findAllActive() {
        return jdbcTemplate.query("SELECT * FROM bet where active = true", getRowMapper());
    }

    private RowMapper<Bet> getRowMapper() {
        return (RowMapper) (resultSet, i) -> new Bet(
                resultSet.getLong("id"),
                resultSet.getInt("number1"),
                resultSet.getInt("number2"),
                resultSet.getInt("number3"),
                resultSet.getInt("number4"),
                resultSet.getInt("number5"),
                resultSet.getInt("number6"),
                resultSet.getLong("user_account_id"),
                resultSet.getTimestamp("datetime").toLocalDateTime(),
                resultSet.getBoolean("active")

        );
    }
}