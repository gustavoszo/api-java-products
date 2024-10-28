package br.com.api.infra.web.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductResponseDto {
    
    private UUID id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    private BigDecimal price;
    private Integer quantityAvaiable;

}
