package br.com.api.product;

import java.util.UUID;

import br.com.api.ProductGateway;
import br.com.api.entities.Product;
import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.usecases.product.FindProductByIdUseCase;

public class FindProductByIdUseCaseImpl implements FindProductByIdUseCase {

    private ProductGateway productGateway;

    public FindProductByIdUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product execute(UUID id) {
       Product product = productGateway.findById(id);
       if (product == null) throw new EntityNotFoundException(String.format("Product id '%s' não encontrado", id));
       return product;
    }
    
}
