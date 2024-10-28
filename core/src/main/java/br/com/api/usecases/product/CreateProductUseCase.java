package br.com.api.usecases.product;

import br.com.api.entities.Product;

public interface CreateProductUseCase {

    Product execute(Product product);

}
