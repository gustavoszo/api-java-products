package br.com.api.user;

import br.com.api.entities.User;
import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.usecases.user.FindUserByIdUseCase;
import br.com.api.UserGateway;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase {

    private UserGateway userGateway;

    public FindUserByIdUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
       User user = userGateway.findById(id);
        if (user == null) throw new EntityNotFoundException(String.format("User com id '%s' não encontrado", id));
        return user;
    }

}
