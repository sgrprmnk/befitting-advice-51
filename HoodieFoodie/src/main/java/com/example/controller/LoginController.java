package com.example.controller;

import com.example.model.LoginDTO;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
public class LoginController {
    @Autowired
    private LoginService customerLogin;

    @PostMapping("/login")
    public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
        String result=customerLogin.logIntoAccount(dto);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
    @PostMapping("/logout")
    public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
        return customerLogin.logOutFromAccount(key);
    }

}
