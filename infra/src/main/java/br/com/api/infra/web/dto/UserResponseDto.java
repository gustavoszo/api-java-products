package br.com.api.infra.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponseDto {

    private Long id;
    private String name;
    private String username;
    private String role;
    
}
