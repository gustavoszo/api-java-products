package br.com.api.infra.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.api.entities.Order;
import br.com.api.infra.persistence.entities.OrderEntity;
import br.com.api.infra.web.dto.OrderCreateDto;
import br.com.api.infra.web.dto.OrderResponseDto;

public class OrderMapper {
    
    public static Order toOrderDomain(OrderCreateDto orderCreateDto) {
        return new ModelMapper().map(orderCreateDto, Order.class);
    }
    
    public static Order toOrderDomain(OrderEntity orderEntity) {
        return new ModelMapper().map(orderEntity, Order.class);
    }
    
    public static List<Order> toOrderDomainList(List<OrderEntity> orderEntityList) {
        return orderEntityList.stream()
            .map(o -> toOrderDomain(o))
            .collect(Collectors.toList());
    }
    
    public static OrderEntity toOrderEntity(Order order) {
        return new ModelMapper().map(order, OrderEntity.class);
    }
    
    public static OrderResponseDto toOrderResponseDto(Order order) {
        return new ModelMapper().map(order,  OrderResponseDto.class);
    }
    
    public static List<OrderResponseDto> toOrderResponseDtoList(List<Order> orders) {
        return orders.stream()
            .map(o -> toOrderResponseDto(o))
            .collect(Collectors.toList());
    }

}
