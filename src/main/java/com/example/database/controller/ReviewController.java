package com.example.database.controller;


import com.example.database.model.Product;
import com.example.database.model.Review;
import com.example.database.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/products/reviews")
    public ArrayList<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("products/reviews/{reviewId}")
    public Review getProductAndReviewById(@PathVariable("reviewId") int reviewId){
        return reviewService.getProductAndReviewById(reviewId);

    }

    @PostMapping("/products/reviews")
    public Review addReviews(@RequestBody Review review){
        return reviewService.addReviews(review);
    }

    @PutMapping("/products/reviews/{reviewId}")
    public Review updateReview(@RequestBody Review review,@PathVariable("reviewId") int reviewId){
        return reviewService.updateReview(review,reviewId);
    }

    @DeleteMapping("/products/reviews/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId){
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/reviews/{reviewId}/products")
    public Product getProducts(@PathVariable("reviewId") int reviewId){
        return reviewService.getProducts(reviewId);
    }
}
