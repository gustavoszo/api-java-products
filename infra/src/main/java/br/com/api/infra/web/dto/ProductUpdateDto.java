package br.com.api.infra.web.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductUpdateDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantityAvaiable;

}
