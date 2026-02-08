package org.example.reviewservice.controllers;

import org.example.reviewservice.adapters.CreateReviewDtoToReviewAdapter;
import org.example.reviewservice.dtos.CreateReviewDto;
import org.example.reviewservice.dtos.ReviewDto;
import org.example.reviewservice.services.ReviewService;
import org.example.uberproject.models.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto request) {
        Review incomingReview = this.createReviewDtoToReviewAdapter.convertDto(request);
        if(incomingReview == null) {
            return new ResponseEntity<>("Invalid booking id", HttpStatus.BAD_REQUEST);
        }

        Review review = this.reviewService.publishReview(incomingReview);
        ReviewDto response = ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
