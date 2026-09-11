package com.naina.naina_artistry.controller;

import com.naina.naina_artistry.model.Review;
import com.naina.naina_artistry.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://naina-artistry-frontend-1.onrender.com"
})
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Add a review
    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    // Get all reviews for a product
    @GetMapping("/{productId}")
    public List<Review> getReviews(@PathVariable int productId) {
        return reviewService.getReviewsByProductId(productId);
    }
}