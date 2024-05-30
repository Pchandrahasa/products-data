package com.example.database.services;

import com.example.database.model.Product;
import com.example.database.model.Review;
import com.example.database.repository.ProductJpaRepository;
import com.example.database.repository.ReviewJpaRepository;
import com.example.database.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements ReviewRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Override
    public ArrayList<Review> getReviews() {
        List<Review> reviewsList = reviewJpaRepository.findAll();
        ArrayList<Review> reviews = new ArrayList<>(reviewsList);
        return reviews;
    }

    @Override
    public Review getProductAndReviewById(int reviewId){
        return reviewJpaRepository.findById(reviewId).get();
    }

    @Override
    public Review addReviews(Review review){
        Product product=review.getProduct();
        int productId=product.getProductId();
        try{
            product=productJpaRepository.findById(productId).get();
            review.setProduct(product);
            reviewJpaRepository.save(review);
            return review;

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Review updateReview(Review review,int reviewId){
        try {
            Review newReview = reviewJpaRepository.findById(reviewId).get();
            if (review.getProduct() != null) {
                int productId = review.getProduct().getProductId();
                Product newProduct = productJpaRepository.findById(productId).get();
                newReview.setProduct(newProduct);
            }
            if (review.getReviewContent() != null) {
                newReview.setReviewContent(review.getReviewContent());
            }
            if (review.getRating() != 0) {
                newReview.setRating(review.getRating());
            }
            reviewJpaRepository.save(newReview);
            return newReview;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteReview(int reviewId){
        try {
            reviewJpaRepository.deleteById(reviewId);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public  Product getProducts(int reviewId){
        try {
            Review exsitingReview = reviewJpaRepository.findById(reviewId).get();
            return exsitingReview.getProduct();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
