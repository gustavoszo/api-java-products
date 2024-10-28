package br.com.api.infra.web.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductCreateDto {
    
    @NotBlank
    private String name;

    private String description;
    
    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantityAvaiable;

}
