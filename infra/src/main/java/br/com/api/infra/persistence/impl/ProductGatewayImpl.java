package br.com.api.infra.persistence.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.ProductGateway;
import br.com.api.entities.Product;
import br.com.api.infra.persistence.entities.ProductEntity;
import br.com.api.infra.persistence.repositories.ProductRepository;
import br.com.api.infra.web.dto.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductGatewayImpl implements ProductGateway {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(Product product) {
        ProductEntity productEntity = productRepository.save(ProductMapper.toProductEntity(product));
        return ProductMapper.toProductDomain(productEntity);
    }


    @Override
    @Transactional(readOnly = true)
    public Product findById(UUID id) {
        var productEntity = productRepository.findById(id).orElse(null);
        if (productEntity == null) return null;
        return ProductMapper.toProductDomain(productEntity);
    }

    @Override
    @Transactional
    public Product update(Product product, UUID id) {
        ProductEntity savedProduct = productRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException(String.format("Product id '%s' não encontrado", id))
        );
        if (product.getName() != null) savedProduct.setName(product.getName());
        if (product.getDescription() != null) savedProduct.setDescription(product.getDescription());
        if (product.getPrice() != null) savedProduct.setPrice(product.getPrice());
        if (product.getQuantityAvaiable() != null) savedProduct.setQuantityAvaiable(product.getQuantityAvaiable());
        return ProductMapper.toProductDomain(savedProduct);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        List<ProductEntity> productsEntity = productRepository.findAll();
        return ProductMapper.toProductDomainList(productsEntity);

    }
    
}
