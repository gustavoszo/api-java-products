package br.com.api.infra.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.entities.Product;
import org.modelmapper.ModelMapper;

import br.com.api.entities.OrderItem;
import br.com.api.infra.web.dto.OrderItemDto;

public class OrderItemMapper {
    
    public static OrderItem toOrderItemDomain(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(new Product());
        orderItem.getProduct().setId(orderItemDto.getProductId());
        orderItem.setAmount(orderItemDto.getAmount());
        return orderItem;
    }

    public static List<OrderItem> toOrderItemDomainList(List<OrderItemDto> orderItensDto) {
        return orderItensDto.stream()
            .map(i -> toOrderItemDomain(i))
            .collect(Collectors.toList());
    }

}
