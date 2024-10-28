package br.com.api.usecases.user;

import br.com.api.entities.User;

public interface FindUserByUsernameUseCase {
    
    User execute(String username);

}
