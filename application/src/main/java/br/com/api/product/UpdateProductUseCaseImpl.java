package br.com.api.product;

import java.util.UUID;

import br.com.api.ProductGateway;
import br.com.api.entities.Product;
import br.com.api.usecases.product.UpdateProductUseCase;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private ProductGateway productGateway;

    public UpdateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product execute(Product product, UUID id) {
        return productGateway.update(product, id);
    }

    
}
