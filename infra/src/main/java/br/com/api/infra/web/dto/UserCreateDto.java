package br.com.api.infra.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCreateDto {
    
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String username;
    @NotBlank
    private String password;

}
