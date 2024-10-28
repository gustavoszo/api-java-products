package br.com.api.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.api.OrderGateway;
import br.com.api.ProductGateway;
import br.com.api.UserGateway;
import br.com.api.order.CancelOrderByIdUseCaseImpl;
import br.com.api.order.CreateOrderUseCaseImpl;
import br.com.api.order.FindAllOrdersUseCaseImpl;
import br.com.api.order.FindOrderByIdUseCaseImpl;
import br.com.api.order.FindOrdersByUserUseCaseImpl;
import br.com.api.order.UpdateStatusOrderUseCaseImpl;
import br.com.api.product.CreateProductUseCaseImpl;
import br.com.api.product.DeleteProductByIdUseCaseImpl;
import br.com.api.product.FindAllProductsUseCaseImpl;
import br.com.api.product.FindProductByIdUseCaseImpl;
import br.com.api.product.UpdateProductUseCaseImpl;
import br.com.api.usecases.order.CancelOrderByIdUseCase;
import br.com.api.usecases.order.CreateOrderUseCase;
import br.com.api.usecases.order.FindAllOrdersUseCase;
import br.com.api.usecases.order.FindOrderByIdUseCase;
import br.com.api.usecases.order.FindOrdersByUserUseCase;
import br.com.api.usecases.order.UpdateStatusOrderUseCase;
import br.com.api.usecases.product.CreateProductUseCase;
import br.com.api.usecases.product.DeleteProductByIdUseCase;
import br.com.api.usecases.product.FindAllProductsUseCase;
import br.com.api.usecases.product.FindProductByIdUseCase;
import br.com.api.usecases.product.UpdateProductUseCase;
import br.com.api.usecases.user.CreateUserUseCase;
import br.com.api.usecases.user.FindUserByIdUseCase;
import br.com.api.usecases.user.FindUserByUsernameUseCase;
import br.com.api.user.CreateUserUseCaseImpl;
import br.com.api.user.FindUserByIdUseCaseImpl;
import br.com.api.user.FindUserByUsernameUseCaseImpl;

@Configuration
public class BeanConfiguration {

    // User
    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway) {
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public FindUserByUsernameUseCase findUserByUsernameUseCase(UserGateway userGateway) {
        return new FindUserByUsernameUseCaseImpl(userGateway);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(UserGateway userGateway) {
        return new FindUserByIdUseCaseImpl(userGateway);
    }

    // Product
    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCaseImpl(productGateway);
    }

    @Bean
    public FindAllProductsUseCase findAllProductsUseCase(ProductGateway productGateway) {
        return new FindAllProductsUseCaseImpl(productGateway);
    }

    @Bean
    public FindProductByIdUseCase findByIdProductUseCase(ProductGateway productGateway) {
        return new FindProductByIdUseCaseImpl(productGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCaseImpl(productGateway);
    }

    @Bean
    public DeleteProductByIdUseCase deleteProductByIdUseCase(ProductGateway productGateway, FindProductByIdUseCase findProductByIdUseCase) {
        return new DeleteProductByIdUseCaseImpl(productGateway, findProductByIdUseCase);
    }

    // Order
    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderGateway orderGateway, FindUserByIdUseCase findUserByIdUseCase, FindProductByIdUseCase findProductByIdUseCase, UpdateProductUseCase updateProductUseCase) {
        return new CreateOrderUseCaseImpl(orderGateway, findUserByIdUseCase, findProductByIdUseCase, updateProductUseCase);
    }
    
    @Bean
    public FindAllOrdersUseCase findAllOrdersUseCase(OrderGateway orderGateway) {
        return new FindAllOrdersUseCaseImpl(orderGateway);
    }

    @Bean
    public FindOrdersByUserUseCase findOrdersByUserUseCase(OrderGateway orderGateway, FindUserByIdUseCase findUserByIdUseCase) {
        return new FindOrdersByUserUseCaseImpl(orderGateway, findUserByIdUseCase);
    }   

    @Bean
    public FindOrderByIdUseCase findOrderByIdUseCase(OrderGateway orderGateway) {
        return new FindOrderByIdUseCaseImpl(orderGateway);
    }

    @Bean 
    public UpdateStatusOrderUseCase updateStatusOrderUseCase(OrderGateway orderGateway) {
        return new UpdateStatusOrderUseCaseImpl(orderGateway);
    }  

    @Bean 
    public CancelOrderByIdUseCase cancelOrderByIdUseCase(OrderGateway orderGateway) {
        return new CancelOrderByIdUseCaseImpl(orderGateway);
    }  

}
