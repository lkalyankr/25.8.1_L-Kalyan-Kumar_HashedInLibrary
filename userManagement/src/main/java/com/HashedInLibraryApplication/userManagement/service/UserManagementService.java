package com.HashedInLibraryApplication.userManagement.service;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import com.HashedInLibraryApplication.userManagement.DTO.UserDTO;
import com.HashedInLibraryApplication.userManagement.ExceptionHandling.UserException;
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

    public UserDTO getUser(Long id) throws UserException {
        UserDTO userDTO = new UserDTO();
        Optional<User> users = userManagementRepository.findById(id);
        if(users.isPresent()){
            BeanUtils.copyProperties(users.get(),userDTO);
            return userDTO;
        } else {
            throw new UserException("User Not Found with id " + id);
        }
    }

    public void createUser(List<UserDTO> userDTOList) {

        userDTOList.forEach(userDTO -> {
            Optional<User> userList = userManagementRepository.findByEmpIdAndRole(userDTO.getEmpId(), userDTO.getRole());
            if(userList.isPresent()){
                throw  new UserException("User Already Exists");
            } else {
                User user = new User();
                BeanUtils.copyProperties(userDTO, user);
                userManagementRepository.save(user);
            }
        });

    }

    public void updateUser(UserDTO userDTO) throws UserException {

        Optional<User> user = userManagementRepository.findByEmpIdAndRole(userDTO.getEmpId(), userDTO.getRole());
        if(user.isPresent()){
            User updatedUser = user.get();
            updatedUser.setEmail(userDTO.getEmail());
            updatedUser.setPassword(userDTO.getPassword());
            userManagementRepository.save(updatedUser);
        } else{
            throw  new UserException("Cannot update, User not found ");
        }

    }

    public void deleteUser(Long id) throws UserException {
        Optional<User> user = userManagementRepository.findById(id);
        if(user.isPresent()) {
            userManagementRepository.delete(user.get());
        } else {
            throw new UserException("Cannot delete, User not found with id " + id);
        }
    }
}

