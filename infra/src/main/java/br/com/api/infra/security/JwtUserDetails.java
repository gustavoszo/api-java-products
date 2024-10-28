package br.com.api.infra.security;

import br.com.api.entities.enums.UserRole;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import br.com.api.infra.persistence.entities.UserEntity;

public class JwtUserDetails extends User {

    private UserEntity userEntity;

    public JwtUserDetails(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(), AuthorityUtils.createAuthorityList(userEntity.getRole().name()));
        this.userEntity = userEntity;
    }

    public Long getId() {
        return this.userEntity.getId();
    }

    public UserRole getRole() {
        return this.userEntity.getRole();
    }
    
}