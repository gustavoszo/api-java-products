package br.com.api;

import br.com.api.entities.Order;
import br.com.api.entities.User;
import br.com.api.entities.enums.StatusOrder;

import java.util.List;
import java.util.UUID;

public interface OrderGateway {

    Order create(Order order);
    Order findById(UUID id);
    Order updateStatus(UUID id, StatusOrder status);
    void cancelOrder(UUID id);
    List<Order> findAllByUser(User user);
    List<Order> findAll();
    
}
