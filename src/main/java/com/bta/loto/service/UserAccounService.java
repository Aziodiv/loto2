package com.bta.loto.service;

import com.bta.loto.model.UserAccount;
import com.bta.loto.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;


@Service
public class UserAccounService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public ResponseEntity registerUser(UserAccount userAccount) {
        final List<UserAccount> userAccounts = userAccountRepository.findByUsername(userAccount.getUsername());
        if (!userAccounts.isEmpty()) {
            return new ResponseEntity<>("user already registrated", HttpStatus.NOT_ACCEPTABLE);

        }
        userAccounts = userAccountRepository.findByEmail(userAccount.getEmail());
        if (!userAccounts.isEmpty()) {
            return new ResponseEntity<>("USer with mentioned email already registered", HttpStatus.NOT_ACCEPTABLE);
        }
        userAccounts = userAccountRepository.findByTaxNumber(userAccount.getEmail());
        if (!userAccounts.isEmpty()) {
            return new ResponseEntity<>("USer with mentioned Tax Number already registered", HttpStatus.NOT_ACCEPTABLE);
        }
        userAccountRepository.save(UserAccount);

        return new ResponseEntity<>("user registerd", HttpStatus.OK);
    }
}
