package br.com.api.order;

import java.util.List;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.entities.User;
import br.com.api.usecases.order.FindOrdersByUserUseCase;
import br.com.api.usecases.user.FindUserByIdUseCase;

public class FindOrdersByUserUseCaseImpl implements FindOrdersByUserUseCase {

    private OrderGateway orderGateway;
    private FindUserByIdUseCase findUserByIdUseCase;

    public FindOrdersByUserUseCaseImpl(OrderGateway orderGateway, FindUserByIdUseCase findUserByIdUseCase) {
        this.orderGateway = orderGateway;
        this.findUserByIdUseCase = findUserByIdUseCase;
    }

    @Override
    public List<Order> execute(Long id) {
        User user = findUserByIdUseCase.execute(id);
        return orderGateway.findAllByUser(user);
    }
    
}
