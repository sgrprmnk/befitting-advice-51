package com.example.service;

import com.example.model.CurrentUserSession;
import com.example.model.Customer;
import com.example.model.LoginDTO;
import com.example.repository.CustomerDao;
import com.example.repository.SessionDao;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private SessionDao sessionDao;

    @Override
    public String logIntoAccount(LoginDTO dto) throws LoginException {
        Customer existingCustomer =customerDao.findByMobileNumber(dto.getMobileNumber());

        if(existingCustomer==null){
            throw new LoginException("Please Enter a Valid mobile number");
        }

        Optional<CurrentUserSession> valCurrentUserSession =sessionDao.findById(existingCustomer.getCustomerId());
        if(valCurrentUserSession.isPresent()){
            throw new LoginException("User already Logged In with this id");
        }
if (existingCustomer.getPassword().equals(dto.getPassword())){
    String key= RandomString.make(6);

    CurrentUserSession currentUserSession=new CurrentUserSession(existingCustomer.getCustomerId(),key, LocalDateTime.now());
    sessionDao.save(currentUserSession);
    return currentUserSession.toString();
}
else
    throw new LoginException("Please Enter a valid password");
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
       CurrentUserSession validCustomerSession =sessionDao.findByUuid(key);
       if (validCustomerSession==null){
           throw new LoginException("User Not Logged In with this number");

       }
       sessionDao.delete(validCustomerSession);
       return "Logged Out Successfully!";

    }
}
