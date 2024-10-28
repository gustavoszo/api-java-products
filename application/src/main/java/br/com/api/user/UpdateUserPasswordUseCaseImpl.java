package br.com.api.user;

import br.com.api.UserGateway;
import br.com.api.usecases.user.UpdateUserPasswordUseCase;

public class UpdateUserPasswordUseCaseImpl implements UpdateUserPasswordUseCase {

    private UserGateway userGateway;

    public UpdateUserPasswordUseCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(Long id, String currentPassword, String newPassword, String confirmPassword) {
        userGateway.updatePassword(id, currentPassword, newPassword, confirmPassword);
    }
    
}