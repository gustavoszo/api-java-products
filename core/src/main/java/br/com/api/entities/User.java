package br.com.api.entities;

import java.time.LocalDateTime;

import br.com.api.entities.enums.UserRole;
import br.com.api.exceptions.ValidationException;

public class User {
    
    private Long id; 
    private String name;
    private String username;
    private String password;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(){}

    public User(Long id, String name, String username, String password, UserRole role, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        setName(name);;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(String name, String username, String password) {
        setName(name);
        this.username = username;
        this.password = password;
        this.role = UserRole.ROLE_USER;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() < 4) throw new ValidationException("O nome deve ter no minímo 4 caracteres");
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
   
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    

}
