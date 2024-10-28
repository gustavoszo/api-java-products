package br.com.api.infra.persistence.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.infra.persistence.entities.OrderEntity;
import br.com.api.infra.persistence.entities.UserEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByUser(UserEntity userEntity);
    
}
