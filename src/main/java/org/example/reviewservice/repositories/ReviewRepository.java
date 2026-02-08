package org.example.reviewservice.repositories;

import org.example.uberproject.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);
    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("SELECT r FROM Booking b INNER JOIN Review r WHERE b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);
}
