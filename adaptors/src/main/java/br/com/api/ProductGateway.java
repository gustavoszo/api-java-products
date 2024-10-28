package br.com.api;

import br.com.api.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {

    Product create(Product product);
    Product findById(UUID id);
    Product update(Product product, UUID id);
    void deleteById(UUID id);
    List<Product> findAll();
    
}
