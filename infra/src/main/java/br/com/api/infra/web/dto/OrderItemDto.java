package br.com.api.infra.web.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {
    
    private UUID productId;
    private Integer amount;

}
