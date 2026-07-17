package com.naina.naina_artistry.service;

import com.naina.naina_artistry.model.Review;
import com.naina.naina_artistry.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Add Review
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get Reviews for a Product
    public List<Review> getReviewsByProductId(int productId) {
        return reviewRepository.findByProductId(productId);
    }
}