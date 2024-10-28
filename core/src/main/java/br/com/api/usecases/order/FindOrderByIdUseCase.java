package br.com.api.usecases.order;

import java.util.UUID;

import br.com.api.entities.Order;

public interface FindOrderByIdUseCase {

    Order execute(UUID orderId);

}
