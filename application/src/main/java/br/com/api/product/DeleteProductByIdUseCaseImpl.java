package br.com.api.product;

import java.util.UUID;

import br.com.api.ProductGateway;
import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.usecases.product.DeleteProductByIdUseCase;
import br.com.api.usecases.product.FindProductByIdUseCase;

public class DeleteProductByIdUseCaseImpl implements DeleteProductByIdUseCase {

    private ProductGateway productGateway;
    private FindProductByIdUseCase findProductByIdUseCase;

    public DeleteProductByIdUseCaseImpl(ProductGateway productGateway, FindProductByIdUseCase findProductByIdUseCase) {
        this.productGateway = productGateway;
        this.findProductByIdUseCase = findProductByIdUseCase;
    }

    @Override
    public void execute(UUID id) {
        var product = findProductByIdUseCase.execute(id);
        if (product == null) throw new EntityNotFoundException(String.format("Product com id '%s' não encontrado", id));
        productGateway.deleteById(id);
    }
    
}