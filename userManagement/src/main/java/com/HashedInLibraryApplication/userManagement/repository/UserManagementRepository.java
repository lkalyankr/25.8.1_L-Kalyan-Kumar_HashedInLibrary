package com.HashedInLibraryApplication.userManagement.repository;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmpIdAndRole(Integer empId, String role);
}
