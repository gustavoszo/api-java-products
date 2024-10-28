package br.com.api.order;

import java.util.List;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.usecases.order.FindAllOrdersUseCase;

public class FindAllOrdersUseCaseImpl implements FindAllOrdersUseCase {

    private OrderGateway orderGateway;

    public FindAllOrdersUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> execute() {
        return orderGateway.findAll();
    } 
    
}
