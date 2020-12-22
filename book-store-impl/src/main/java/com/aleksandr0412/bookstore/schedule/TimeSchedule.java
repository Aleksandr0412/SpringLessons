package com.aleksandr0412.bookstore.schedule;

import com.aleksandr0412.bookstore.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "scheduling.timeout", name = {"enabled"}, matchIfMissing = false)
public class TimeSchedule {

    private final OrderService orderService;
    private static final Logger log = LoggerFactory.getLogger(TimeSchedule.class.getName());

    public TimeSchedule(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(fixedDelayString = "${scheduling.timeout.interval}")
    public void schedule() {
        long countOfOrders = orderService.getAll().size();
        log.info("Number of orders {}", countOfOrders);
    }

}