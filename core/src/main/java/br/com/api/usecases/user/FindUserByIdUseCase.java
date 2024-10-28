package br.com.api.usecases.user;

import br.com.api.entities.User;

public interface FindUserByIdUseCase {
    
    User execute(Long id);

}
