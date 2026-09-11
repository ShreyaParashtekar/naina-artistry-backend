package com.naina.naina_artistry.controller;

import com.naina.naina_artistry.model.Order;
import com.naina.naina_artistry.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://naina-artistry-frontend-1.onrender.com"
})
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getOrders() {
        return service.getAllOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id,
                             @RequestBody Order order) {
        return service.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        service.deleteOrder(id);
    }
}