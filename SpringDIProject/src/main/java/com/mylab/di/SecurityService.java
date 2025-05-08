package com.mylab.di;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public boolean authenticate(String username) {
        return username != null && !username.isEmpty();
    }
}
