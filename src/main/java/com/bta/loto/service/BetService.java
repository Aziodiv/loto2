package com.bta.loto.service;

import com.bta.loto.model.Bet;
import com.bta.loto.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

public class BetService {
    @Autowired
    private BetRepository betRepository;


    public ResponseEntity registerBet(Bet bet) {
        bet.setUserAccountId(1l);
        bet.setDateTime(LocalDateTime.now());
        bet.setActive(true);
        betRepository.save(bet);

        return new ResponseEntity<>("Your bet was successfully registered", OK);
    }
}
