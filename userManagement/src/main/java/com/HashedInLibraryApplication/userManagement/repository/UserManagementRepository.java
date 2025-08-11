package com.HashedInLibraryApplication.userManagement.repository;

import com.HashedInLibraryApplication.userManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<User, Integer> {
}
