package br.com.api.order;

import java.util.UUID;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.entities.enums.StatusOrder;
import br.com.api.usecases.order.FindOrderByIdUseCase;
import br.com.api.usecases.order.UpdateStatusOrderUseCase;

public class UpdateStatusOrderUseCaseImpl implements UpdateStatusOrderUseCase {

    private OrderGateway orderGateway;

    public UpdateStatusOrderUseCaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(UUID id, String status) {
        StatusOrder statusOrder = null;
        switch (status) {
            case "PROCESSING":
                statusOrder = StatusOrder.PROCESSING;
                break;
            case "SENT":
                statusOrder = StatusOrder.SENT;
                break;
            case "DELIVERED":
                statusOrder = StatusOrder.DELIVERED;
                break;
            case "CANCELED":
                statusOrder = StatusOrder.CANCELED;
                break;
        }
        return orderGateway.updateStatus(id, statusOrder);
    }
    
}
