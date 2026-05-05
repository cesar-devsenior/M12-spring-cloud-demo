package com.devsenior.cdiaz.order.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devsenior.cdiaz.order.model.entity.OrderEntity;
import com.devsenior.cdiaz.order.model.entity.OrderStatus;
import com.devsenior.cdiaz.order.repository.OrderRepository;

@Component
public class InitialDataRunner implements CommandLineRunner {

    private Logger log;
    private final OrderRepository orderRepository;

    public InitialDataRunner(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        log = LoggerFactory.getLogger(InitialDataRunner.class);
    }

    @Override
    public void run(String... args) throws Exception {
        orderRepository.saveAll(List.of(
                new OrderEntity("ORD-001", 1L, 100.0, OrderStatus.CREADO),
                new OrderEntity("ORD-002", 2L, 200.0, OrderStatus.ENVIADO)));
        log.info("Pedidos insertados en la base de datos H2");
    }

}
