package br.com.api.infra.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.infra.persistence.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> { 

}
