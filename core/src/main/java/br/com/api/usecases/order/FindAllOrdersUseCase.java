package br.com.api.usecases.order;

import java.util.List;

import br.com.api.entities.Order;

public interface FindAllOrdersUseCase {
    
    List<Order> execute();

}
