package com.HashedInLibraryApplication.userManagement.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = {"empId", "role"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name Cannot be Blank")
    @Size(max=45, message = "The name field cannot exceed 45 characters")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int empId;

    @Email(message= "Please enter a valid email address")
    @Size(max=45, message = "The Email field cannot exceed 45 characters")
    @NotBlank(message = "Email Cannot be Blank")
    @Column(nullable = false)
    private String email;

    @Size(max=100, message = "The Password field cannot exceed 100 characters")
    @NotBlank(message = "Password Cannot be Blank")
    @Column(nullable = false)
    private String password;

    @Size(max=15, message = "The Role field cannot exceed 45 characters")
    @Column(nullable = false)
    @NotBlank(message = "Password Cannot be Blank")
    private String role;
}
