package br.com.api.usecases.product;

import java.util.UUID;

public interface DeleteProductByIdUseCase {

    void execute(UUID id);

}
