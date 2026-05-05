package com.devsenior.cdiaz.order.model.dto;

import com.devsenior.cdiaz.order.model.entity.OrderStatus;

public record OrderCreateRequest(
        String orderId,
        Long userId,
        Double total,
        OrderStatus status
) {
}
