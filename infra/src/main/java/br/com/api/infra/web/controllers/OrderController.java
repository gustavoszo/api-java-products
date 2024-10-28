package br.com.api.infra.web.controllers;

import br.com.api.entities.enums.UserRole;
import br.com.api.infra.web.dto.OrderUpdateDto;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.entities.Order;
import br.com.api.entities.OrderItem;
import br.com.api.entities.enums.StatusOrder;
import br.com.api.infra.security.JwtUserDetails;
import br.com.api.infra.web.dto.OrderCreateDto;
import br.com.api.infra.web.dto.OrderResponseDto;
import br.com.api.infra.web.dto.mapper.OrderItemMapper;
import br.com.api.infra.web.dto.mapper.OrderMapper;
import br.com.api.usecases.order.CancelOrderByIdUseCase;
import br.com.api.usecases.order.CreateOrderUseCase;
import br.com.api.usecases.order.FindAllOrdersUseCase;
import br.com.api.usecases.order.FindOrderByIdUseCase;
import br.com.api.usecases.order.FindOrdersByUserUseCase;
import br.com.api.usecases.order.UpdateStatusOrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final FindAllOrdersUseCase findAllOrdersUseCase; 
    private final FindOrdersByUserUseCase findOrdersByUserUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final UpdateStatusOrderUseCase updateStatusOrderUseCase;
    private final CancelOrderByIdUseCase cancelOrderByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody OrderCreateDto orderCreateDto, @AuthenticationPrincipal JwtUserDetails userDetails) {
        Order order = new Order();

        List<OrderItem> itens = OrderItemMapper.toOrderItemDomainList(orderCreateDto.getItens());
        order.setitens(itens);
        Long userId = userDetails.getId();

        order = createOrderUseCase.execute(order, userId);

        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{id}")
            .buildAndExpand(order.getId())
            .toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll() {
        List<Order> orders = findAllOrdersUseCase.execute(); 
        return ResponseEntity.ok(OrderMapper.toOrderResponseDtoList(orders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getById(@PathVariable("id") UUID id, @AuthenticationPrincipal JwtUserDetails userDetails) {
        Order order = findOrderByIdUseCase.execute(id);

        if (userDetails.getRole() != UserRole.ROLE_ADMIN) {
            if (userDetails.getId() != order.getUser().getId()) {
                throw new AccessDeniedException("");
            }
        }

        return ResponseEntity.ok(OrderMapper.toOrderResponseDto(order));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelOrder(@PathVariable("id") UUID id, @AuthenticationPrincipal JwtUserDetails userDetails) {
        Order order = findOrderByIdUseCase.execute(id);

        if (userDetails.getRole() != UserRole.ROLE_ADMIN) {
            if (userDetails.getId() != order.getUser().getId()) {
                throw new AccessDeniedException("Access Denied");
            }
        }

        cancelOrderByIdUseCase.execute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByUser(@AuthenticationPrincipal JwtUserDetails userDetails) {
        List<Order> orders = findOrdersByUserUseCase.execute(userDetails.getId());
        return ResponseEntity.ok(OrderMapper.toOrderResponseDtoList(orders));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderResponseDto> updateOrderStatus(@PathVariable("id") UUID id, @RequestBody OrderUpdateDto orderUpdateDto) {
        Order order = updateStatusOrderUseCase.execute(id, orderUpdateDto.getStatus());
        return ResponseEntity.ok(OrderMapper.toOrderResponseDto(order));
    }

}
