package br.com.api.order;

import java.util.UUID;

import br.com.api.OrderGateway;
import br.com.api.usecases.order.CancelOrderByIdUseCase;

public class CancelOrderByIdUseCaseImpl implements CancelOrderByIdUseCase {

    private OrderGateway orderGateway;

    public CancelOrderByIdUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public void execute(UUID orderId) {
        orderGateway.cancelOrder(orderId);
    }
    
}
