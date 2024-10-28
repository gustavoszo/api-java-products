package br.com.api.order;

import java.util.UUID;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.exceptions.EntityNotFoundException;
import br.com.api.usecases.order.FindOrderByIdUseCase;

public class FindOrderByIdUseCaseImpl implements FindOrderByIdUseCase {

    private OrderGateway orderGateway;

    public FindOrderByIdUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(UUID orderId) {
        Order order = orderGateway.findById(orderId);
        if (order == null) throw new EntityNotFoundException(String.format("Pedido com id '%s' não encontrado", orderId));
        return order;
    }
    
}
