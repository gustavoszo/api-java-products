package br.com.api.product;

import br.com.api.ProductGateway;
import br.com.api.entities.Product;
import br.com.api.usecases.product.CreateProductUseCase;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private ProductGateway productGateway;

    public CreateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product execute(Product product) {
        return productGateway.create(product);
    }
    
}
