package com.delivery.api.useCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;
import com.delivery.api.domain.product.Product;
import com.delivery.api.exceptions.runTimeExceptions.NoCustumerException;
import com.delivery.api.exceptions.runTimeExceptions.OutOfStockException;
import com.delivery.api.service.CustomerService;
import com.delivery.api.service.OrderItemService;
import com.delivery.api.service.OrderService;
import com.delivery.api.service.ProductService;
import com.delivery.api.usecase.OrderCreateUseCase;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;
import com.delivery.api.usecase.dto.OrderItemCreateRequest;

public class OrderCreateUseCaseTest {

    @Mock
    private OrderService orderService;

    @Mock
    private CustomerService customerService;

    @Mock
    private ProductService productService;

    @Mock
    private OrderItemService orderItemService;

    @InjectMocks
    private OrderCreateUseCase orderCreateUseCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateOrderWhenRequestIsValid() {
        UUID customerId = new UUID(0, 0);
        List<OrderItemCreateRequest> items = List.of(
            new OrderItemCreateRequest("PROD1", 2)
        );
        OrderCreateRequest request = new OrderCreateRequest(customerId, items);

        Customer mockCustomer = new Customer(); 
        mockCustomer.setName("João Silva");
        mockCustomer.setEmail("joao@email.com");

        Product mockProduct = new Product();
        mockProduct.setCode("PROD1");
        mockProduct.setStockQuantity(10);

        Order mockOrder = new Order(); 

        List<OrderItem> mockOrderItems = new ArrayList<>();

        when(customerService.findCustomerByCode(customerId)).thenReturn(mockCustomer);
        when(orderService.createOrder(mockCustomer)).thenReturn(mockOrder);
        when(productService.getByCode("PROD1")).thenReturn(mockProduct);
        when(productService.decreaseQuantity(mockProduct, 2)).thenReturn(mockProduct);
        when(orderItemService.createOrderItems(any(), eq(mockOrder))).thenReturn(mockOrderItems);

        OrderCreateResponse response = orderCreateUseCase.execute(request);
        assertNotNull(response);
        assertEquals("João Silva", response.customer_name());
    }

    @Test
    void shouldThrowNoCustumerExceptionWhenCustomerIdIsNull() {
        OrderCreateRequest request = new OrderCreateRequest(null, List.of());

        assertThrows(NoCustumerException.class, () -> orderCreateUseCase.execute(request));
    }

    @Test
    void shouldThrowOutOfStockExceptionWhenQuantityExceedsStock() {
        UUID customerId = new UUID(0, 0);
        List<OrderItemCreateRequest> items = List.of(
            new OrderItemCreateRequest("PROD1", 20) // Estoque é 10
        );
        OrderCreateRequest request = new OrderCreateRequest(customerId, items);

        Customer mockCustomer = new Customer();
        Product mockProduct = new Product();
        mockProduct.setStockQuantity(10);

        when(customerService.findCustomerByCode(customerId)).thenReturn(mockCustomer);
        when(productService.getByCode("PROD1")).thenReturn(mockProduct);

        assertThrows(OutOfStockException.class, () -> orderCreateUseCase.execute(request));
    }

}
