package nz.co.goodspeed.chargenetbe.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import nz.co.goodspeed.chargenetbe.model.Order;
import nz.co.goodspeed.chargenetbe.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepository = orderRepo;
    }

    @PostMapping
    public void newOrder(@RequestBody Order orderInput) {
        orderRepository.save(orderInput);
    }

    @PutMapping("bulk")
    public void orderCollection(@RequestBody List<Order> orderList) {
        orderList.forEach( i -> {
            i.getOrderLines().forEach(
                    line -> {
                        line.setOrder(i);
                    }
            );
        });
        orderRepository.saveAll(orderList);
    }

}
