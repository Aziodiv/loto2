package com.bta.loto.repository;

import com.bta.loto.model.PlayResult;
import com.bta.loto.model.UserAccount;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PlayResultRepository extends AbstractRepository<PlayResult> {

    @Override
    public int save(PlayResult entity) {
        final String sql = "INSERT INTO user_account (number1, number2, number3, number4, number5, number6, dateTime)" +
                "values (nextval('play_result_seq')," +
                ":number1," +
                ":number2," +
                ":number3," +
                ":number4," +
                ":number5," +
                ":number6" +
                ":dateTime)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("number1", entity.getNumber1());
        map.addValue("number2", entity.getNumber2());
        map.addValue("number3", entity.getNumber3());
        map.addValue("number4", entity.getNumber4());
        map.addValue("number5", entity.getNumber5());
        map.addValue("number6", entity.getNumber6());
        map.addValue("dateTime", entity.getDateTime());

        return nameParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public List<PlayResult> findAll() {
        return jdbcTemplate.query("SELECT * FROM PLAY_RESULT", getRowMapper());

    }


    public List<PlayResult> findByDate(LocalDateTime dateTime) {
        String query = "SELECT * FROM USER_ACCOUNT where datetime = :datetime";
        MapSqlParameterSource map = new MapSqlParameterSource().addValue("datetime", dateTime);
        map.addValue("datetime", dateTime);
        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
    }


    private RowMapper<PlayResult> getRowMapper() {
        return new RowMapper() {
            @Override
            public PlayResult mapRow(ResultSet resultSet, int i) throws SQLException {
                return new PlayResult(
                        resultSet.getInt("number1"),
                        resultSet.getInt("number2"),
                        resultSet.getInt("number3"),
                        resultSet.getInt("number4"),
                        resultSet.getInt("number5"),
                        resultSet.getInt("number6"),
                        resultSet.getTimestamp("dateTime").toLocalDateTime());

            }
        };
    }
}
