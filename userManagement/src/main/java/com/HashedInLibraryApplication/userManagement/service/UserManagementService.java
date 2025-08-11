package com.HashedInLibraryApplication.userManagement.service;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import com.HashedInLibraryApplication.userManagement.UserDTO;
import com.HashedInLibraryApplication.userManagement.repository.UserManagementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {

    @Autowired
    UserManagementRepository userManagementRepository;

    public List<User> getAllUsers() {
        List<User> users = userManagementRepository.findAll();
        return users;
    }

    public Optional<User> getUser(int id) {
        Optional<User> users = userManagementRepository.findById(id);
        if(users.isPresent()){
            return users;
        } else {
            return null;
        }
    }

    public void createUser(List<UserDTO> userDTOList) {

        userDTOList.forEach(userDTO -> {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            userManagementRepository.save(user);
        });

    }
}
