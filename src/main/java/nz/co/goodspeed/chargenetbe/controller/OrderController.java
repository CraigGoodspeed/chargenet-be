package nz.co.goodspeed.chargenetbe.controller;

import nz.co.goodspeed.chargenetbe.model.Order;
import nz.co.goodspeed.chargenetbe.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepository = orderRepo;
    }

    @PostMapping
    public void newOrder(Order orderInput) {
        orderRepository.save(orderInput);
    }
}
