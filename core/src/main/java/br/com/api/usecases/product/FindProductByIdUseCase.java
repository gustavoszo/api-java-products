package br.com.api.usecases.product;

import java.util.UUID;

import br.com.api.entities.Product;

public interface FindProductByIdUseCase {

    Product execute(UUID id);

}
