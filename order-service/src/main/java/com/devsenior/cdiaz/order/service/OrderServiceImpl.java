package com.devsenior.cdiaz.order.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.devsenior.cdiaz.order.client.UserClient;
import com.devsenior.cdiaz.order.model.dto.OrderCreateRequest;
import com.devsenior.cdiaz.order.model.dto.OrderResponse;
import com.devsenior.cdiaz.order.model.entity.OrderEntity;
import com.devsenior.cdiaz.order.model.entity.OrderStatus;
import com.devsenior.cdiaz.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    public OrderServiceImpl(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    @Override
    public OrderResponse createOrder(OrderCreateRequest request) {
        if (request == null || !StringUtils.hasText(request.orderId())) {
            throw new IllegalArgumentException("orderId is required");
        }
        if (request.userId() == null) {
            throw new IllegalArgumentException("userId is required");
        }
        if (request.total() == null) {
            throw new IllegalArgumentException("total is required");
        }

        OrderStatus status = request.status() != null ? request.status() : OrderStatus.CREADO;

        OrderEntity order = new OrderEntity(
                request.orderId(),
                request.userId(),
                request.total(),
                status);

        order = orderRepository.save(order);
        var user = userClient.getUserById(order.getUserId());

        return new OrderResponse(
                order.getOrderId(),
                user,
                order.getTotal(),
                order.getStatus());
    }

    @Override
    public OrderResponse getOrderDetails(String orderId) {
        if (!StringUtils.hasText(orderId)) {
            throw new IllegalArgumentException("orderId is required");
        }

        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        var user = userClient.getUserById(order.getUserId());

        return new OrderResponse(
                order.getOrderId(),
                user,
                order.getTotal(),
                order.getStatus());
    }
}
