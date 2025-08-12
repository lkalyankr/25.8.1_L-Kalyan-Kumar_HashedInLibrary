package com.HashedInLibraryApplication.userManagement.controller;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import com.HashedInLibraryApplication.userManagement.DTO.UserDTO;
import com.HashedInLibraryApplication.userManagement.ExceptionHandling.UserException;
import com.HashedInLibraryApplication.userManagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id){
         User user = userManagementService.getUser(id);
        return user;
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody List<UserDTO> userDTO){
        userManagementService.createUser(userDTO);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserDTO userDTO){
            userManagementService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
            userManagementService.deleteUser(id);
            return ResponseEntity.ok("User Deleted Successfully");
    }

}
