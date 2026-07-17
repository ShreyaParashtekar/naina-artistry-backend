package com.naina.naina_artistry.repository;

import com.naina.naina_artistry.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}