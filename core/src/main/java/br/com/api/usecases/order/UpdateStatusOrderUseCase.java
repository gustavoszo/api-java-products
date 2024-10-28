package br.com.api.usecases.order;

import br.com.api.entities.Order;
import br.com.api.entities.enums.StatusOrder;

import java.util.UUID;

public interface UpdateStatusOrderUseCase {

    Order execute(UUID id, String status);

}
