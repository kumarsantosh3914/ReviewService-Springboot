package org.example.reviewservice.adapters;

import org.example.reviewservice.dtos.CreateReviewDto;
import org.example.uberproject.models.Review;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
