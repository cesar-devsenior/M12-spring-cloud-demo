package com.devsenior.cdiaz.order.service;

import com.devsenior.cdiaz.order.model.dto.OrderCreateRequest;
import com.devsenior.cdiaz.order.model.dto.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderCreateRequest request);

    OrderResponse getOrderDetails(String orderId);
}
