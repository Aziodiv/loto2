package com.bta.loto.controller;

import com.bta.loto.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("play")
public class PlayController {

    @Autowired
    private PlayService playService;

    @GetMapping
    public ResponseEntity play(){
        return ResponseEntity.ok("Play");

    }

}
