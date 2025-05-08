package com.mylab.di;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testUserServiceDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-user-di.xml");

        UserService userService = context.getBean(UserService.class);
        assertNotNull(userService, "UserService should not be null");

        UserRepository userRepo = userService.getUserRepository();
        assertNotNull(userRepo, "UserRepository should not be null");
        assertEquals("MySQL", userRepo.getDbType(), "DB type should be MySQL");

        SecurityService securityService = userService.getSecurityService();
        assertNotNull(securityService, "SecurityService should not be null");

        assertTrue(userService.registerUser("hun"), "User registration should return true");
    }
}