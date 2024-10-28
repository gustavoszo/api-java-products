package br.com.api.usecases.product;

import java.util.List;

import br.com.api.entities.Product;

public interface FindAllProductsUseCase {

    List<Product> execute();

}
