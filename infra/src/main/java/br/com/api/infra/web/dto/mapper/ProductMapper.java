package br.com.api.infra.web.dto.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.api.entities.Product;
import br.com.api.infra.persistence.entities.ProductEntity;
import br.com.api.infra.web.dto.ProductCreateDto;
import br.com.api.infra.web.dto.ProductResponseDto;
import br.com.api.infra.web.dto.ProductUpdateDto;

public class ProductMapper {

    public static Product toProductDomain(ProductCreateDto dto) {
        return new ModelMapper().map(dto, Product.class);
    }

    public static Product toProductDomain(ProductEntity productEntity) {
        return new ModelMapper().map(productEntity, Product.class);
    }

    public static Product toProductDomain(ProductUpdateDto dto) {
        Product product = new Product();
        if (dto.getName() != null) product.setName(dto.getName());
        if (dto.getDescription() != null) product.setName(dto.getDescription());
        if (dto.getPrice() != null) product.setPrice(dto.getPrice());
        if (dto.getQuantityAvaiable() != null) product.setQuantityAvaiable(dto.getQuantityAvaiable());
        return product;
    }

    public static List<Product> toProductDomainList(List<ProductEntity> productsEntity) {
        return productsEntity.stream()
            .map(p -> toProductDomain(p))
            .collect(Collectors.toList());
    }

    public static ProductEntity toProductEntity(Product product) {
        return new ModelMapper().map(product, ProductEntity.class);
    }

    public static ProductResponseDto toResponseDto(Product product) {
        return new ModelMapper().map(product, ProductResponseDto.class);
    }

    public static List<ProductResponseDto> toResponseDtoList(List<Product> products) {
        return products.stream()
            .map(p -> toResponseDto(p))
            .collect(Collectors.toList());
    }
    
}
