package br.com.api.product;

import java.util.List;

import br.com.api.ProductGateway;
import br.com.api.entities.Product;
import br.com.api.usecases.product.FindAllProductsUseCase;

public class FindAllProductsUseCaseImpl implements FindAllProductsUseCase {

    private ProductGateway productGateway;

    public FindAllProductsUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> execute() {
        return productGateway.findAll();
    }
    
}
