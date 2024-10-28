package br.com.api.infra.persistence.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.api.entities.User;
import br.com.api.UserGateway;
import br.com.api.infra.persistence.entities.UserEntity;
import br.com.api.infra.persistence.repositories.UserRepository;
import br.com.api.infra.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User create(User user) {
        UserEntity userEntity = UserMapper.toUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return UserMapper.toUserDomain(userRepository.save(userEntity));
    }

    @Override
    public void updatePassword(Long id, String currentPassword, String newPassword, String confirmPassword) {
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) return null;
        return UserMapper.toUserDomain(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        if (userEntity != null) return UserMapper.toUserDomain(userEntity);
        return null;
    }
    
}
