package com.example.database.repository;

import com.example.database.model.Product;
import com.example.database.model.Review;

import java.util.ArrayList;

public interface ReviewRepository {

    ArrayList<Review> getReviews();

    Review getProductAndReviewById(int reviewId);

    Review addReviews(Review review);

    Review updateReview(Review review,int reviewId);

    void deleteReview(int reviewId);

    Product getProducts(int reviewId);
}
