package br.com.api.infra.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.infra.persistence.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> { 

    Optional<UserEntity> findByUsername(String username);
    
}
