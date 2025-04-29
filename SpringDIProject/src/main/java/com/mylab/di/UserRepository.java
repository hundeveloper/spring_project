package com.mylab.di;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String getDbType() {
        return "MySQL";
    }
}
