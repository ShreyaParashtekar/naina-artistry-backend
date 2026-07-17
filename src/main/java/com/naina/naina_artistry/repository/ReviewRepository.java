package com.naina.naina_artistry.repository;

import com.naina.naina_artistry.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByProductId(int productId);

}