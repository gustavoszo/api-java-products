package br.com.api.usecases.order;

import java.util.UUID;

public interface CancelOrderByIdUseCase {
    
    void execute(UUID orderId);

}
