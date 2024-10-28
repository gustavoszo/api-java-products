package br.com.api.infra.web.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.entities.Product;
import br.com.api.infra.web.dto.ProductCreateDto;
import br.com.api.infra.web.dto.ProductResponseDto;
import br.com.api.infra.web.dto.ProductUpdateDto;
import br.com.api.infra.web.dto.mapper.ProductMapper;
import br.com.api.usecases.product.CreateProductUseCase;
import br.com.api.usecases.product.DeleteProductByIdUseCase;
import br.com.api.usecases.product.FindAllProductsUseCase;
import br.com.api.usecases.product.FindProductByIdUseCase;
import br.com.api.usecases.product.UpdateProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductByIdUseCase deleteProductByIdUseCase;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductCreateDto productCreateDto) {
        Product product = createProductUseCase.execute(ProductMapper.toProductDomain(productCreateDto));
       
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        List<Product> products = findAllProductsUseCase.execute();
        return ResponseEntity.ok(ProductMapper.toResponseDtoList(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable("id") UUID id) {
        Product product = findProductByIdUseCase.execute(id);
        return ResponseEntity.ok(ProductMapper.toResponseDto(product));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable("id") UUID id, @Valid @RequestBody ProductUpdateDto productUpdateDto) {
        Product product = ProductMapper.toProductDomain(productUpdateDto);
        product = updateProductUseCase.execute(product, id);
        return ResponseEntity.ok(ProductMapper.toResponseDto(product));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        deleteProductByIdUseCase.execute(id);
        return ResponseEntity.ok().build();
    }
    
}
