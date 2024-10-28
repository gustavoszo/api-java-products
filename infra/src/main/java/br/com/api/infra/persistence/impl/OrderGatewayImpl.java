package br.com.api.infra.persistence.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.entities.User;
import br.com.api.entities.enums.StatusOrder;
import br.com.api.infra.persistence.entities.OrderEntity;
import br.com.api.infra.persistence.repositories.OrderRepository;
import br.com.api.infra.web.dto.mapper.OrderMapper;
import br.com.api.infra.web.dto.mapper.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderGatewayImpl implements OrderGateway {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    @Transactional
    public Order create(Order order) {
        OrderEntity orderEntity = orderRepository.save(OrderMapper.toOrderEntity(order));
        return OrderMapper.toOrderDomain(orderEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Order findById(UUID id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);
        if (orderEntity == null) return null;
        return OrderMapper.toOrderDomain(orderEntity);
    }

    @Transactional
    @Override
    public Order updateStatus(UUID id, StatusOrder status) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(String.format("Pedido com id '%s' não encontrado", id))
        );
        orderEntity.setStatus(status);
        return OrderMapper.toOrderDomain(orderEntity);
    }

    @Transactional
    @Override
    public void cancelOrder(UUID id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(String.format("Pedido com id '%s' não encontrado", id))
        );
        orderEntity.setStatus(StatusOrder.CANCELED);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> findAllByUser(User user) {
        List<OrderEntity> list = orderRepository.findAllByUser(UserMapper.toUserEntity(user));
        return OrderMapper.toOrderDomainList(list);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> findAll() {
        List<OrderEntity> list = orderRepository.findAll();
        return OrderMapper.toOrderDomainList(list);
    }
    
}
