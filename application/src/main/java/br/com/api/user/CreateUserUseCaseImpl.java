package br.com.api.user;

import br.com.api.entities.User;
import br.com.api.entities.enums.UserRole;
import br.com.api.exceptions.UsernameUniqueValidationException;
import br.com.api.usecases.user.CreateUserUseCase;
import br.com.api.UserGateway;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private UserGateway userGateway;

    public CreateUserUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        User foundUser = userGateway.findByUsername(user.getUsername());
        if (foundUser != null) throw new UsernameUniqueValidationException(String.format("username '%s' já cadastrado", user.getUsername()));
        user.setRole(UserRole.ROLE_USER);
        return userGateway.create(user);
    }
    
}