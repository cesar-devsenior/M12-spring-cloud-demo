package com.devsenior.cdiaz.order.model.dto;

import com.devsenior.cdiaz.order.model.entity.OrderStatus;

public record OrderResponse(
        String orderId,
        UserResponse user,
        Double total,
        OrderStatus status) {

}
