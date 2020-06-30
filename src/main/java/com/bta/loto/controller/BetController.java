package com.bta.loto.controller;


import com.bta.loto.model.Bet;
import com.bta.loto.repository.BetRepository;
import com.bta.loto.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("bets")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody Bet bet) {
        return betService.registerBet(bet);
    }
}
