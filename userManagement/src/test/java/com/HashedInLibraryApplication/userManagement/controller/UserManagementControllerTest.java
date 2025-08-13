package com.HashedInLibraryApplication.userManagement.controller;

import com.HashedInLibraryApplication.userManagement.service.UserManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserManagementControllerTest {

    @Autowired
    private UserManagementService userManagementService;

    @Test
    void getAllUsers() {
        userManagementService.getAllUsers();

    }

    @Test
    void getUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}