package br.com.api.usecases.user;

import br.com.api.entities.User;

public interface CreateUserUseCase {

    User execute(User user);
    
}
