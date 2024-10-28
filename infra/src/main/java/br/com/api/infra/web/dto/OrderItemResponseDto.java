package br.com.api.infra.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class OrderItemResponseDto {

    private Long id;
    private ProductResponseDto product;
    private Integer amount;
    private BigDecimal subTotal;

}
