package com.bta.loto.controller;


import com.bta.loto.model.Bet;
import com.bta.loto.model.PlayResult;
import com.bta.loto.repository.BetRepository;
import com.bta.loto.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("bets")
public class BetController {

    @Autowired
    private BetService betService;

    @Autowired
    private BetRepository betRepository;

    @GetMapping
    public  ResponseEntity<List<Bet>> getAll(){
        final  List<Bet> bets = betRepository.findAll();
        return new ResponseEntity<>(bets, HttpStatus.OK);
    }


    @PostMapping("register")
    public ResponseEntity register(@RequestBody Bet bet) {
        return betService.registerBet(bet);
    }


}    @Override
public List<Bet> findAll() {
    return jdbcTemplate.query("SELECT * FROM BET", getRowMapper());
}

    public List<Bet> findAllActive(Boolean active) {
        String query = "SELECT * FROM BET where active = :active";
        MapSqlParameterSource map = new MapSqlParameterSource().addValue("active", active);
        map.addValue("active", active);
        return nameParameterJdbcTemplate.query(query, map, getRowMapper());
    }
