package com.example.service;

import com.example.model.LoginDTO;

import javax.security.auth.login.LoginException;

public interface LoginService {
    public String logIntoAccount(LoginDTO dto) throws LoginException;
    public String logOutFromAccount(String key) throws LoginException;
}
