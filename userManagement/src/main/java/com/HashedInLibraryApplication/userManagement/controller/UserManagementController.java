package com.HashedInLibraryApplication.userManagement.controller;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import com.HashedInLibraryApplication.userManagement.UserDTO;
import com.HashedInLibraryApplication.userManagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@RestController
public class UserManagementController {

    @Autowired
    UserManagementService userManagementService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
       List<User> users = userManagementService.getAllUsers();
       return users;
    }

    @RequestMapping("/getUser/{id}")
    public Optional<User> getUser(@PathVariable int id){
        Optional<User> user = userManagementService.getUser(id);
        return user;
    }

    @RequestMapping("/createUser")
    public void createUser(@RequestBody List<UserDTO> userDTO){
        userManagementService.createUser(userDTO);
    }


}
