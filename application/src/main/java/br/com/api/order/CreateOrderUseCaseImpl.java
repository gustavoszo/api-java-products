package br.com.api.order;

import java.math.BigDecimal;

import br.com.api.OrderGateway;
import br.com.api.entities.Order;
import br.com.api.entities.OrderItem;
import br.com.api.entities.Product;
import br.com.api.entities.User;
import br.com.api.entities.enums.StatusOrder;
import br.com.api.exceptions.ValidationException;
import br.com.api.usecases.order.CreateOrderUseCase;
import br.com.api.usecases.product.FindProductByIdUseCase;
import br.com.api.usecases.product.UpdateProductUseCase;
import br.com.api.usecases.user.FindUserByIdUseCase;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private OrderGateway orderGateway;
    private FindUserByIdUseCase findUserByIdUseCase;
    private FindProductByIdUseCase findProductByIdUseCase;
    private UpdateProductUseCase updateProductUseCase;

    public CreateOrderUseCaseImpl(OrderGateway orderGateway, FindUserByIdUseCase findUserByIdUseCase, FindProductByIdUseCase findProductByIdUseCase, UpdateProductUseCase updateProductUseCase) {
        this.orderGateway = orderGateway;
        this.findUserByIdUseCase = findUserByIdUseCase; 
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }

    @Override
    public Order execute(Order order, Long userId) {
        User user = findUserByIdUseCase.execute(userId);
        order.setUser(user);

        order.setTotal(new BigDecimal(0));

        for (OrderItem i : order.getitens()) {
            i.setProduct(findProductByIdUseCase.execute(i.getProduct().getId()));

            // Validar estoque
            if (i.getProduct().getQuantityAvaiable() < i.getAmount()) {
                throw new ValidationException(String.format("Quantidade indisponível de estoque para o produto '%s'", i.getProduct().getName()));
            }

            // Passar subtotal
            BigDecimal subTotal = i.getProduct().getPrice().multiply(BigDecimal.valueOf(i.getAmount()));
            i.setSubTotal(subTotal);

            // Passar total
            order.setTotal(order.getTotal().add(subTotal));
        }

        order.setStatus(StatusOrder.PROCESSING);
        order = orderGateway.create(order);

        // Diminuir estoque do produto comprado
        order.getitens().forEach(i -> {
            Integer quantityAvaiable = i.getProduct().getQuantityAvaiable() - i.getAmount();
            Product updateProduct = new Product();
            updateProduct.setQuantityAvaiable(quantityAvaiable);
            updateProductUseCase.execute(updateProduct, i.getProduct().getId());
        });

        return order;
    }
    
}
