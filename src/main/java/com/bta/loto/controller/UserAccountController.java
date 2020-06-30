package com.bta.loto.controller;


import com.bta.loto.model.UserAccount;
import com.bta.loto.repository.UserAccountRepository;
import com.bta.loto.service.UserAccounService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccounService userAccounService;


    //..........localhost:8888/users => all users
    @GetMapping("users")
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userAccountRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //..........localhost:8888/users/ivan => one user
    @GetMapping("{username}")
    public ResponseEntity<UserAccount> getUserByUsername(@PathVariable String username) {
        List<UserAccount> users = userAccountRepository.findByUsername(username);

        return new ResponseEntity<>(users.get(0), HttpStatus.OK);
    }


    //..........localhost:8888/users/register => registeruser

    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Validated UserAccount userAccount) {
        return userAccounService.registerUser(userAccount);

    }

}
