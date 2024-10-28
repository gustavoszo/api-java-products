package br.com.api.infra.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.entities.User;
import br.com.api.infra.web.dto.UserCreateDto;
import br.com.api.infra.web.dto.mapper.UserMapper;
import br.com.api.usecases.user.CreateUserUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<br.com.api.infra.web.dto.UserResponseDto> create(@Validated @RequestBody UserCreateDto userCreateDto) {
        User user = createUserUseCase.execute(UserMapper.toUserDomain(userCreateDto));
        var userResponseDto = UserMapper.toUserResponseDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
        
    
}
