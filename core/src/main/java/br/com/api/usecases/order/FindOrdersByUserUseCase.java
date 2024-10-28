package br.com.api.usecases.order;

import java.util.List;

import br.com.api.entities.Order;

public interface FindOrdersByUserUseCase {

    List<Order> execute(Long id);

}
