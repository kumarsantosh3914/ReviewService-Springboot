package org.example.reviewservice.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewDto {
    private String content;
    private Double rating;
    private Long bookingId;
}
