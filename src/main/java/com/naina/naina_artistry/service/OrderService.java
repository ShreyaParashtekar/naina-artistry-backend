package com.naina.naina_artistry.service;

import com.naina.naina_artistry.model.Order;
import com.naina.naina_artistry.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naina.naina_artistry.model.Product;
import com.naina.naina_artistry.repository.ProductRepository;

import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private ProductRepository productRepository;

    // Get all orders
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    // Save a new order
    public Order addOrder(Order order) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Map<String, Object>> items =
                    mapper.readValue(order.getItems(),
                            new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> item : items) {

                int productId = (Integer) item.get("id");
                int quantity = (Integer) item.get("quantity");

                Product product = productRepository.findById(productId).orElseThrow();

                if (product.getStock() < quantity) {
                    throw new RuntimeException(
                            product.getName() + " has only " + product.getStock() + " item(s) left."
                    );
                }

                product.setStock(product.getStock() - quantity);

                productRepository.save(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return repo.save(order);
    }

    // Delete an order
    public void deleteOrder(int id) {
        repo.deleteById(id);
    }

    // Update order status
    public Order updateOrder(int id, Order updatedOrder) {

        Order order = repo.findById(id).orElseThrow();

        order.setStatus(updatedOrder.getStatus());

        return repo.save(order);
    }
}