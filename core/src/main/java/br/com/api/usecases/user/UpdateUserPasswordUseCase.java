package br.com.api.usecases.user;

public interface UpdateUserPasswordUseCase {

    void execute(Long id, String currentPassword, String newPassword, String confirmPassword);
    
}
