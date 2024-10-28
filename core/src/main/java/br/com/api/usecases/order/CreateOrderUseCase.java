package br.com.api.usecases.order;

import br.com.api.entities.Order;

public interface CreateOrderUseCase {

    Order execute(Order order, Long userId);

}
