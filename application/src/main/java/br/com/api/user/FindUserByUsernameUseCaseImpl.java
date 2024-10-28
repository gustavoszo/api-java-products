package br.com.api.user;

import br.com.api.entities.User;
import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.usecases.user.FindUserByUsernameUseCase;
import br.com.api.UserGateway;

public class FindUserByUsernameUseCaseImpl implements FindUserByUsernameUseCase {

    private UserGateway userGateway;

    public FindUserByUsernameUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(String username) {
        User user = userGateway.findByUsername(username);
        if (user == null) throw new EntityNotFoundException(String.format("User '%s' não encontrado", username));
        return user;
    }
    
}
