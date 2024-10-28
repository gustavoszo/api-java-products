package br.com.api;

import br.com.api.entities.User;

public interface UserGateway {

    User create(User user);
    void updatePassword(Long id, String currentPassword, String newPassword, String confirmPassword);
    User findById(Long id);
    User findByUsername(String username);
    
}
