package org.example.reviewservice.services;

import org.example.uberproject.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<Review> findReviewById(Long id);
    List<Review> findAllReviews();
    boolean deleteReviewById(Long id);
    Review publishReview(Review review);
    Review updateReview(Long id, Review review);
}
