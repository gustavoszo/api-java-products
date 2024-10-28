package br.com.api.usecases.product;

import br.com.api.entities.Product;

import java.util.UUID;

public interface UpdateProductUseCase {

    Product execute(Product product, UUID id);

}
