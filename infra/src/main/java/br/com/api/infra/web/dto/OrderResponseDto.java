package br.com.api.infra.web.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import br.com.api.entities.OrderItem;
import br.com.api.entities.User;
import br.com.api.entities.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderResponseDto {
    
    private UUID id;
    private UserResponseDto user;
    private List<OrderItemResponseDto> itens;
    private StatusOrder status;
    private BigDecimal total;

}
