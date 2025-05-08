package com.mylab.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public boolean registerUser(String username) {
        if (securityService.authenticate(username)) {
            System.out.println("User registered with DB: " + userRepository.getDbType());
            return true;
        }
        return false;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }
}
